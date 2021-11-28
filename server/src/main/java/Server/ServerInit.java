package Server;

import Server.handlers.addPlayerToGameHandler;
import Server.handlers.getGameStateHandler;
import Server.handlers.newGameHandler;
import Server.handlers.newPlayerHandler;
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

        GameContent context = GameContent.getInstance();
        Game game = context.getGame();

        QueuedThreadPool queuedThreadPool =
                new QueuedThreadPool(200, 8, 60000);

        app = Javalin.create(config ->
                config.server(() ->
                        new Server(queuedThreadPool))).start(7000);

        app.get("/", ctx -> ctx.result("Server Launch Successful"));
        app.routes(() -> {
            post("api/new-player", new newPlayerHandler(context));
            post("api/new-game", new newGameHandler(context));
            post("api/add-player", new addPlayerToGameHandler(context));
            get("api/get-gamestate", new getGameStateHandler(context));
            get("/api/status", ctx -> {
                ctx.result("OK");
            });
        });
    }

    public Javalin getApp() {return app;}

  public static void main(String[] args) {
        CLI.INST.init();
        CLI.INST.parseArgs(args);
        int portNumber = CLI.INST.getPortNumber();

        new ServerInit().getApp().start(portNumber);

  }
}