package library;

import lombok.Getter;
import lombok.Setter;

public class Game {

    @Getter @Setter
    private GameState gameState;

    public Game(){
        gameState = new GameState();
    }
}
