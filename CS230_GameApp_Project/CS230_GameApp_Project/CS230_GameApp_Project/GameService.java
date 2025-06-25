
package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static GameService instance = null;
    private List<Game> games = new ArrayList<>();
    private long nextGameId = 1;

    private GameService() {}

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    public Game addGame(String name) {
        for (Game g : games) {
            if (g.getName().equalsIgnoreCase(name)) {
                return g;
            }
        }
        Game game = new Game(nextGameId++, name);
        games.add(game);
        return game;
    }

    public Game getGame(int index) {
        return games.get(index);
    }

    public Game getGame(long id) {
        for (Game g : games) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    public Game getGame(String name) {
        for (Game g : games) {
            if (g.getName().equalsIgnoreCase(name)) {
                return g;
            }
        }
        return null;
    }

    public int getGameCount() {
        return games.size();
    }
}
