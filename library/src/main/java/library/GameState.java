package library;

 import lombok.Getter;
 import lombok.Setter;

/** @author Madison May */

public class GameState {
  // @Getter @Setter
  // private BoardLocation p1Location;

  public GameState() {}

  @Getter @Setter
  private Player player1;

  @Getter @Setter
  private Player player2;


}
