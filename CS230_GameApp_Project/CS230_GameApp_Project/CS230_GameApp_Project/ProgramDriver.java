
package com.gamingroom;

public class ProgramDriver {
    public static void main(String[] args) {
        GameService service = GameService.getInstance();
        System.out.println("\nAbout to test initializing game data...");
        Game game1 = service.addGame("Game #1");
        System.out.println(game1);
        Game game2 = service.addGame("Game #2");
        System.out.println(game2);

        SingletonTester tester = new SingletonTester();
        tester.testSingleton();
    }
}
