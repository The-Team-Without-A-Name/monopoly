package Server.handlers;

import Server.GameContent;
import com.google.gson.Gson;
import io.javalin.http.Context;

import java.util.Map;

public class newPlayerHandler extends BasicHandler {

    public newPlayerHandler(GameContent content) {
        super(content);
    }

    private String playerID;

    @Override
    public void processData(Map<String, String> data) {
        playerID = content.newPlayer(data.get("playerName"));
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
