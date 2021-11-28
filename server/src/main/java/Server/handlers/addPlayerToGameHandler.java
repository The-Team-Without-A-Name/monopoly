package Server.handlers;

import Server.GameContent;
import com.google.gson.Gson;
import io.javalin.http.Context;

import java.util.Map;

public class addPlayerToGameHandler extends BasicHandler{
    public addPlayerToGameHandler(GameContent content) {
        super(content);
    }

    private String gameID;

    @Override
    public void processData(Map<String, String> data) {
        gameID = data.get("gameID");
        String playerID = data.get("playerID");

        content.addPlayerToGame(playerID);
    }

    @Override
    public Object getMessage() {
        return content.getGame();
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
