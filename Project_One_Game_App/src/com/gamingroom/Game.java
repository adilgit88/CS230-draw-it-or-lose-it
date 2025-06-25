
package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

public class Game extends Entity {
    private List<Team> teams = new ArrayList<>();

    public Game(long id, String name) {
        super(id, name);
    }

    public Team addTeam(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        Team team = new Team(GameService.getInstance().getNextTeamId(), name);
        teams.add(team);
        return team;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
