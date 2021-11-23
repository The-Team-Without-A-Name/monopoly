package Server;

import io.javalin.Javalin;
import library.Game;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

/**
 * @author Rowan, Madison
 * This class initializes the server and displays result message.
 */


public class ServerInit {

    private Javalin app;

    public ServerInit() {
        Game game = new Game();

        QueuedThreadPool queuedThreadPool =
                new QueuedThreadPool(200, 8, 60000);

        app = Javalin.create(config ->
                config.server(() ->
                        new Server(queuedThreadPool))).start(7000);

        app.get("/", ctx -> ctx.result("Server Launch Successful"));
        app.routes(() -> {
            get("/api/state", ctx -> ctx.json(game.getGameState()));
            post("/api/update", ctx -> {
                game.update();
                ctx.json(game.getGameState());
            });


            get("/api/status", ctx -> {
                ctx.result("OK");
            });
        });
    }

    public Javalin getApp() {return app;}

  public static void main(String[] args) {
        new ServerInit().getApp().start(7000);
    //
  }
}