package Server;
import io.javalin.Javalin;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;


public class ServerInit {
    public static void main(String[] args) {
        QueuedThreadPool queuedThreadPool =
                new QueuedThreadPool(200, 8, 60000);

        Javalin app = Javalin.create(config ->
                config.server(() ->
                        new Server(queuedThreadPool))).start(7000);

        app.get("/", ctx -> ctx.result("Hello World"));
    }
}