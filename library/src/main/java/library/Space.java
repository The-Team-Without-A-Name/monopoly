package library;

public abstract class Space {

    protected String spaceName;
    protected int price;
    protected int rent;
    protected boolean owned;
    protected Player owner;

    /*   Not sure if we need these:
    private int playerLocation;
    private int landOn;

     */

    //constructor
    Space(String spaceName, int price, int rent, boolean owned, Player player){

        this.spaceName=spaceName;
        this.price=price;
        this.rent=price;
        this.owned=owned;
        this.owner =player;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

}
