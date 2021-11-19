package library;

 import lombok.Getter;
 import lombok.Setter;

/** @author Madison May */

public class GameState {
  // @Getter @Setter
  // private BoardLocation p1Location;

  public GameState(Player player1, Player player2) {
      this.player1 = player1;
      this.player2 = player2;
  }

  @Getter @Setter
  private Player player1;

  @Getter @Setter
  private Player player2;


}
