package Server.handlers;

import Server.GameContent;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

/**
 * @author Madison May
 * An interface for the basic server handlers
 * I used some basic structure in Isaac Griffith's tic-tac-toe project.
 */

public abstract class BasicHandler implements Handler {
    protected GameContent content;

    public BasicHandler(GameContent content) {
        this.content = content;
    }

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        if (Objects.equals(ctx.contentType(), "application/json")) {
            Gson gson = new Gson();
            Map<String, String> contextData = ctx.bodyAsClass(Map.class);

            processData(contextData);

            ctx.json(getMessage());
        } else {
            ctx.json(getErrorMessage());
        }
    }

    public abstract void processData(Map<String, String> data);

    public abstract Object getMessage();

    public abstract String getErrorMessage();
}
