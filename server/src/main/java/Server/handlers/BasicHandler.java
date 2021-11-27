package Server.handlers;

import Server.GameContent;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Map;
import java.util.Objects;

/**
 * @author Madison May
 * An interface for the basic server handlers
 * I used some basic structure in Isaac Griffith's tic-tac-toe project because my group said they would do the server, and they didn't.
 */

public abstract class BasicHandler implements Handler {
    protected GameContent content;

    public BasicHandler(GameContent content) {this.content = content;}

    @Override
    public void handle(Context context) throws Exception {
        if (Objects.equals(context.contentType(), "application/json")) {
            Map<String, String> contextData = context.bodyAsClass(Map.class);

            processData(contextData);

            context.json(getMessage());
        } else {
            context.json(getErrorMessage());
        }
    }

    public abstract void processData(Map<String, String > data);

    public abstract Object getMessage();

    public abstract String getErrorMessage();
}
