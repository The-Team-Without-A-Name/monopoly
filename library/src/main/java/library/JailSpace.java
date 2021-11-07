package library;
import library.Player;
import library.Dice;
/**
 * jail space class
 */


public class JailSpace {



    //Method to set Player Location To the Jail Space, player cannot move until rolling a double, or paying a fee




    public void PlayerInJail(Player player){
        while (player.inPrison)   {
            if(player.getOutOfJailFree){
                player.inPrison = false;
                player.getOutOfJailFree = false;
            }

            else if (player.inPrison){
                int jailDice;
                jailDice = Dice.roll(player);
                if (jailDice >=10){
                    player.inPrison = false;
                    break;
                }
            }
            else{
                player.playerBudget =Player.playerBudget - 200;
                player.inPrison = false;
            }
        }
    }
}