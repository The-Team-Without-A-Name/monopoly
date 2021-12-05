package Server.handlers;

import io.javalin.http.Context;
import library.Player;

import java.io.IOException;
/**
 * @author Rowan Murphy
 * Gamestate update controller
 * a controller to pass a context message to the server, hopefully this will resolve prior issues.
 */

public class GamestateController {
    private static Player player1;
    private static Player player2;
   // Player player1 = new Player("Play1");
    //Player player2 = new Player("Play2");
    public static void getGamestate(Context context) throws IOException {
        context.json(updateGameStateHandler.updateGameStates(player1, player2));
    }


}
