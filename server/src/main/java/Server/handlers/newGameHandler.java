package Server.handlers;

import Server.GameContent;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Map;

public class newGameHandler extends BasicHandler{
    public newGameHandler(GameContent content) {
        super(content);
    }



    @Override
    public void processData(Map<String, String> data) {
        String playerID = data.get("playerID");
        content.newGame(playerID);
    }

    @Override
    public Object getMessage() {
        return null;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
