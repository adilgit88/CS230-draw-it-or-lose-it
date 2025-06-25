package com.gamingroom.gameauth.auth;


import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.*;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;


public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
		
	private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );
 
    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException 
    {
        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword())) 
        {
            // FIXME: Finish the authorize method based on BasicAuth Security Example for new GameUser

        }
        
    if ("password".equals(credentials.getPassword())) {
        switch (credentials.getUsername()) {
            case "admin":
                return Optional.of(new GameUser("admin", new HashSet<>(Arrays.asList("ADMIN"))));

            case "user":
            case "guest":
            case "player":
                return Optional.of(new GameUser(credentials.getUsername(), new HashSet<>(Arrays.asList("USER"))));

        }
    }
    return Optional.empty();
    }
}
