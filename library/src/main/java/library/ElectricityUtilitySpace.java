package library;
/*
class to handle electricity utility space
 */
public class ElectricityUtilitySpace extends Space{
    private int diceTotal;
    private int landOn;

    //gets the owner for the space
    @Override
    public Player getOwner() {
        return super.getOwner();
    }

    //boolean to see if it is owned
    @Override
    public boolean isOwned() {
        return super.isOwned();
    }

    //get rent price
    @Override
    public int getRent() {
        return super.getRent();
    }
}
