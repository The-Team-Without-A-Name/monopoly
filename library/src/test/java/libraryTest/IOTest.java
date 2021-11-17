package libraryTest;

import library.GameState;
import library.GameStateIO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @author Madison May */

public class IOTest {


    /** @author Madison May
     * Tests the read method in GameStateIO*/
    @Test
    private void testGameStateWrite() {
        GameState testGameState = new GameState();

        GameStateIO testIO = new GameStateIO();

        testIO.SaveGameStateToJson(testGameState);

        GameState newGameState = testIO.LoadGameStateFromJson();

        Assertions.assertNotNull(newGameState);

    }

}
