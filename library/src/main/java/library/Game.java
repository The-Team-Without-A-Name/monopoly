package library;

import lombok.Getter;
import lombok.Setter;

/**
 * Game class uses getter/setter methods
 * Game class makes new GameState
 */

public class Game {

    @Getter @Setter
    private GameState gameState;

    public Game(){
        gameState = new GameState();
    }
}
