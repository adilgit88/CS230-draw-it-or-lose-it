
package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static GameService instance;
    private static long nextGameId = 1;
    private static long nextTeamId = 1;
    private static long nextPlayerId = 1;

    private List<Game> games = new ArrayList<>();

    private GameService() {}

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    public Game addGame(String name) {
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(name)) {
                return game;
            }
        }
        Game game = new Game(nextGameId++, name);
        games.add(game);
        return game;
    }

    public Game getGame(String name) {
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(name)) {
                return game;
            }
        }
        return null;
    }

    public long getNextTeamId() {
        return nextTeamId++;
    }

    public long getNextPlayerId() {
        return nextPlayerId++;
    }

    public List<Game> getGames() {
        return games;
    }
}
