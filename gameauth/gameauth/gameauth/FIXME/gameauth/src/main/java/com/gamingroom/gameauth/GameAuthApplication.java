package com.gamingroom.gameauth;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gamingroom.gameauth.auth.GameAuthenticator;
import com.gamingroom.gameauth.auth.GameAuthorizer;
import com.gamingroom.gameauth.auth.GameUser;

import com.gamingroom.gameauth.controller.GameUserRESTController;
import com.gamingroom.gameauth.controller.RESTClientController;

import com.gamingroom.gameauth.healthcheck.AppHealthCheck;
import com.gamingroom.gameauth.healthcheck.HealthCheckController;
import javax.ws.rs.client.Client;



public class GameAuthApplication extends Application<Configuration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameAuthApplication.class);

	@Override
	public void initialize(Bootstrap<Configuration> b) {
	}

	@Override
	public void run(Configuration c, Environment e) throws Exception {
	    // Register REST controller
	    e.jersey().register(new com.gamingroom.gameauth.controller.GameUserRESTController());

	    // Create Jersey client (no block!)
	    Client client = new JerseyClientBuilder(e).build("DemoRESTClient");

	    LOGGER.info("Registering REST resources");

	    // Application health check
	    e.healthChecks().register("APIHealthCheck", new AppHealthCheck(client));

	    // Run multiple health checks
	    e.jersey().register(new HealthCheckController(e.healthChecks()));

	    // Setup Basic Security
	    e.jersey().register(new AuthDynamicFeature(
	        new BasicCredentialAuthFilter.Builder<GameUser>()
	            .setAuthenticator(new GameAuthenticator())
	            .setAuthorizer(new GameAuthorizer())
	            .setRealm("App Security")
	            .buildAuthFilter()));
	    e.jersey().register(new AuthValueFactoryProvider.Binder<>(GameUser.class));
	    e.jersey().register(RolesAllowedDynamicFeature.class);
	}

	public static void main(String[] args) throws Exception {
		new GameAuthApplication().run(args);
	}
}