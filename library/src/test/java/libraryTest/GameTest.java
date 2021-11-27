package libraryTest;

import library.Game;
import library.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GameTest {

    /** @author Madison May
     * Tests the read method in GameStateIO doesn't hit an exception*/
    @Test
    public void canAlterGamePlayers() {
        Game testGame = new Game();
        Player p1 = testGame.getPlayer1();
        Player p2 = testGame.getPlayer2();

        p1.setPlayerBudget(50);
        p2.setPosition(new Point(0, 0));

        Assertions.assertEquals(50, testGame.getPlayer1().getPlayerBudget());
        Assertions.assertEquals(1500, testGame.getPlayer2().getPlayerBudget());

        Assertions.assertEquals(new Point(0, 0), testGame.getPlayer2().getPosition());
    }
}
