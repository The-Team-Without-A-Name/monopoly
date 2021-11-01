package library;

/**
 * handles Rail Road Space
 */
public class RailroadSpace extends Space{

    //gets owner, method called from super class Space
    @Override
    public Player getOwner() {
        return super.getOwner();
    }

    //gets rent price, method called from super class Space
    @Override
    public int getRent() {
        return super.getRent();
    }

    //see if this space is owned, method called from super class Space
    @Override
    public boolean isOwned() {
        return super.isOwned();
    }
}
