package Server.handlers;

import Server.GameContent;
import com.google.gson.Gson;
import io.javalin.http.Context;
import library.Player;

import java.util.Map;

public class newPlayerHandler extends BasicHandler {

    public newPlayerHandler(GameContent content) {
        super(content);
    }

    private String playerID;


    Player player1 = new Player("player1");
    Player player2 = new Player("player2");
    @Override
    public void processData(Map<String, String> data) {
        playerID = "0";//GameContent.newPlayer(data.get("playerName"));
    }

    @Override
    public Object getMessage() {
        return Map.of("playerID", playerID);
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
