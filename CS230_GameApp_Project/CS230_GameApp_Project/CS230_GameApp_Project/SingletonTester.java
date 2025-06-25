
package com.gamingroom;

public class SingletonTester {
    public void testSingleton() {
        System.out.println("\nAbout to test the singleton...");
        GameService service = GameService.getInstance();
        for (int i = 0; i < service.getGameCount(); i++) {
            System.out.println(service.getGame(i));
        }
    }
}
