package library;

import lombok.Getter;
import lombok.Setter;


/**
 * GameState uses getter&setter methods to get player location from BoardLocation class
 */
public class GameState {
    @Getter @Setter
    private BoardLocation p1Location;


    public GameState() {

    }

}
