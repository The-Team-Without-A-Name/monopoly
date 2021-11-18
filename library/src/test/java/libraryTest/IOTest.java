package libraryTest;

import library.GameState;
import library.IO;
import library.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @author Madison May */

public class IOTest {


    /** @author Madison May
     * Tests the read method in GameStateIO doesn't hit an exception*/
    @Test
    public void testGameStateWriteIsNotNull() {
        Player testP1 = new Player("p1");
        Player testP2 = new Player("p2");
        GameState testGameState = new GameState(testP1, testP2);

        IO testIO = new IO();

        testIO.SaveGameStateToJson(testGameState);

        GameState newGameState = testIO.LoadGameStateFromJson();

        Assertions.assertNotNull(newGameState);

    }

    /** @author Madison May
     * Tests the read method in GameStateIO has correct player info */
    @Test
    public void testGameStateWriteHasCorrectPlayerInfo() {
        Player testP1 = new Player("p1");
        Player testP2 = new Player("p2");

        GameState testGameState = new GameState(testP1, testP2);

        testP1.setPlayerBudget(500);

        IO testIO = new IO();
        testIO.SaveGameStateToJson(testGameState);
        GameState newGameState = testIO.LoadGameStateFromJson();

        Player newP1 = newGameState.getPlayer1();
        Player newP2 = newGameState.getPlayer2();

        Assertions.assertEquals("p1", newP1.getPlayerName());
        Assertions.assertEquals("p2", newP2.getPlayerName());
        Assertions.assertEquals(500, newP1.getPlayerBudget());
        Assertions.assertEquals(1500, newP2.getPlayerBudget());

    }

}
