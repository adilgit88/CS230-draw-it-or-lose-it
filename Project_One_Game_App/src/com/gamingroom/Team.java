
package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

public class Team extends Entity {
    private List<Player> players = new ArrayList<>();

    public Team(long id, String name) {
        super(id, name);
    }

    public Player addPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        Player player = new Player(GameService.getInstance().getNextPlayerId(), name);
        players.add(player);
        return player;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
