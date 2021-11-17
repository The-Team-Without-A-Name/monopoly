package libraryTest;

import library.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
  Player testPlayer = new Player("testPlayer");

  @Test
  public void isNotBancrupt() {
    Assertions.assertFalse(testPlayer.isBankrupt());
  }

  @Test
  public void isNotInPrison() {
    Assertions.assertFalse(testPlayer.isInPrison());
  }
}
