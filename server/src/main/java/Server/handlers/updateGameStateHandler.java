package Server.handlers;

import Server.GameContent;

import java.util.Map;

public class updateGameStateHandler extends BasicHandler{
    public updateGameStateHandler(GameContent content) {
        super(content);
    }

    private String gameID;

    @Override
    public void processData(Map<String, String> data) {
        gameID = data.get("gameID");
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
