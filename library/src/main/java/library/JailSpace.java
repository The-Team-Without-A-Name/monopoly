package library;

/** jail space class */
public class JailSpace {

  // Method to set Player Location To the Jail Space, player cannot move until rolling a double, or
  // paying a fee

  public void PlayerInJail(Player player) {
    while (player.inPrison) {
      if (player.getOutOfJailFree) {
        player.inPrison = false;
        player.getOutOfJailFree = false;
      } else if (player.inPrison) {
        int jailDice;
        jailDice = Dice.roll(player);
        if (jailDice >= 10) {
          player.inPrison = false;
          break;
        }
      } else {
        player.setPlayerBudget(player.getPlayerBudget() - 200);
        player.inPrison = false;
      }
    }
  }
}
