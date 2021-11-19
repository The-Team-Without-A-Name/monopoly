package library;

// import lombok.Getter;
// import lombok.Setter;

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

  // @Getter @Setter
  private GameState gameState;

  public Game() {
    //gameState = new GameState();
  }
}
