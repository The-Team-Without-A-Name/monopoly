package library;

/** jail space class */
public class JailSpace {

  // Method to set Player Location To the Jail Space, player cannot move until rolling a double, or
  // paying a fee

  public void PlayerInJail(Player player) {
    while (player.isInPrison()) {
      if (player.isGetOutOfJailFree()) {
        player.setInPrison(false);
        player.setGetOutOfJailFree(false);
      } else if (player.isInPrison()) {
        int jailDice;
        jailDice = Dice.roll(player);
        if (jailDice >= 10) {
          player.setInPrison(false);
          break;
        }
      } else {
        player.setPlayerBudget(player.getPlayerBudget() - 200);
        player.setInPrison(false);
      }
    }
  }
}
