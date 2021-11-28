package Server.handlers;

import Server.GameContent;
import com.google.gson.Gson;
import io.javalin.http.Context;

import java.util.Map;

public class getGameStateHandler extends BasicHandler{
    public getGameStateHandler(GameContent content) {
        super(content);
    }

    private String gameID;

    @Override
    public void processData(Map<String, String> data) {
        gameID = data.get("gameID");
    }

    @Override
    public Object getMessage() {
        return content.getGameState();
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
