package library;


import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * This is where the game logic should be. Everyone threw that sort of thing in my GameBoardController because it was
 * the only class that did anything, but most of that stuff should be here.
 *
 * Game class uses getter/setter methods Game class makes new GameState
 *
 * <p>need gameloop to call functions at the start of each turn, call boardlocation, diceroll, jail,
 * etc. gameloop should only exit when game has winner or game is exited.
 */
public class Game {

  @Getter @Setter
  private GameState gameState;

  @Getter @Setter
  private List<Player> players;

  @Getter @Setter
  private Player player1;

  @Getter @Setter
  private Player player2;

  @Getter
  private String gameID;

  /** @author Madison May
   * Creates a new game and initializes players*/

  public Game() {
    gameID = UUID.randomUUID().toString();
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  /** @author Madison May
   * This should be called in the SERVER. */
  public void update() {
    IO gameSaver = new IO();
    gameState = new GameState(player1, player2);
    gameSaver.SaveGameStateToJson(gameState);

  }


}
