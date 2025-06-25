
package com.gamingroom;

public class ProgramDriver {
    public static void main(String[] args) {
        GameService service = GameService.getInstance();
        Game game = service.addGame("Draw It or Lose It");
        Team team = game.addTeam("Red Team");
        Player player = team.addPlayer("Adil");

        System.out.println("Game created: " + game.getName());
        System.out.println("Team added: " + team.getName());
        System.out.println("Player added: " + player.getName());
    }
}
