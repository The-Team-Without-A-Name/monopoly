package Server;

import io.javalin.Javalin;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import library.Player;

import java.util.List;
import java.util.Objects;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

/**
 * This class initializes the server and displays result message.
 */

public class ServerInit {
    public static void main(String[] args) {
        QueuedThreadPool queuedThreadPool =
                new QueuedThreadPool(200, 8, 60000);

        Javalin app = Javalin.create(config ->
                config.server(() ->
                        new Server(queuedThreadPool))).start(7000);

        app.get("/", ctx -> ctx.result("Server Launch Successful"));
        app.routes(() -> {

            get("/api/state", ctx -> ctx.json(Player.ReadGameState()));
            post("/api/update", ctx -> {

            });


            get("/api/status", ctx -> {
                ctx.result("OK");
            });
        });
    }
}