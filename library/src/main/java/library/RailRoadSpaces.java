package library;

public class RailRoadSpaces extends Space {

  public RailRoadSpaces(String spaceName, int price, int rent, boolean owned, Player player) {
    super(spaceName, price, rent, owned, player);
  }

  /** handles Rail Road Space */

  // gets owner, method called from super class Space
  @Override
  public Player getOwner() {
    return super.getOwner();
  }

  // gets rent price, method called from super class Space
  @Override
  public int getRent() {
    return super.getRent();
  }

  // see if this space is owned, method called from super class Space
  @Override
  public boolean isOwned() {
    return super.isOwned();
  }
}
