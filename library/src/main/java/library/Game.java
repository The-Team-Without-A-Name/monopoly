package library;

import lombok.Getter;
import lombok.Setter;

/**
 * Game class uses getter/setter methods
 * Game class makes new GameState
 *
 * need gameloop to call functions at the start of each turn, call boardlocation, diceroll, jail, etc.
 * gameloop should only exit when game has winner or game is exited.
 */

public class Game {

    @Getter @Setter
    private GameState gameState;

    public Game(){
        gameState = new GameState();
    }
}
