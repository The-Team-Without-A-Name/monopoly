package library;

/**
 * handles water utility space
 */
public class WaterUtilitySpace extends Space{
    private int diceTotal;
    private int landOn;


    //get owner for the space
    @Override
    public Player getOwner() {
        return super.getOwner();
    }

    //whether it is owned or not
    @Override
    public boolean isOwned() {
        return super.isOwned();
    }

    // get rent
    @Override
    public int getRent() {
        return super.getRent();
    }
}
