package Client;

import com.google.gson.Gson;
import library.GameState;

import javax.script.ScriptEngine;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

/**
 * Connection class that connects with the server.
 */

public class Connection {

    //PLACEHOLDER IDK WHY THESE WORK OR WHAT THE SYNTAX OR HTTP ON EACH DOES
    private static final String RESET_CALL = "http://%s:%s/api/reset";
    private static final String STATE_CALL = "http://%s:%s/api/state";
    private static final String UPDATE_CALL = "http://%s:%s/api/update";
    private static final String STATUS_CALL = "http://%s:%s/api/status";

    String address;
    String port;
    boolean initialized = false;
    HttpClient client;

    //Private Default Constructor
    private Connection() {
    }


    //Helper Class
    private static class ConnectionHelper {
        private static final Connection INSTANCE = new Connection();
    }

    public static Connection instance() {
        return ConnectionHelper.INSTANCE;
    }



//@param address, address needed for connection
//@param port, port needed for connection

    public void initialize(String address, String port){
        this.address = address;
        this.port = port;
        initialized = true;
        //no clue why or how this works, need to read more into http methods
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
    }

    //sets values to null for disconnect
    public void disconnect() {
        address = null;
        port = null;
        client = null;
    }

    private HttpRequest makeGet(String apiCall){
        return HttpRequest.newBuilder()
                .uri(URI.create(String.format(apiCall, address, port)))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();
    }

    /**
     * @author Madison May
     * @return
     */
    public GameState sendUpdate(GameState gameState) throws IOException, InterruptedException {
        Gson gson = new Gson();
        String jsonGameState = gson.toJson(gameState);

        HttpRequest request = createPost(UPDATE_CALL, jsonGameState);
        return getGameState(request);
    }

    public GameState getCurrentState() throws IOException, InterruptedException {
        HttpRequest httpRequest = createGet(STATE_CALL);
        return getGameState(httpRequest);
    }

    /**
     * This method may not be entirely necessary
     * I just put the method in because Rowan put the variables for it in.
     * @return the gamestate of the reset game
     * @throws IOException if it couldn't connect through the network
     * @throws InterruptedException if it took more than 35 seconds
     */
    public GameState resetGame() throws IOException, InterruptedException {
        HttpRequest request = createGet(RESET_CALL);
        return getGameState(request);
    }


    /**
     * @author Madison May
     */
    private HttpRequest createPost(String apiCall, String jsonGameState) {
        return HttpRequest.newBuilder()
                .uri(URI.create(String.format(apiCall, address, port)))
                .timeout(Duration.ofSeconds(35))
                .header("Post Content", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonGameState))
                .build();
    }

    private HttpRequest createGet(String apiCall) {
        return HttpRequest.newBuilder()
                .uri(URI.create(String.format(apiCall, address, port)))
                .timeout(Duration.ofSeconds(35))
                .GET()
                .build();
    }

    private GameState getGameState(HttpRequest httpRequest) throws IOException, InterruptedException {
        Gson gson = new Gson();
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        GameState gameState = gson.fromJson(httpResponse.body(), GameState.class);
        return gameState;
    }

    public boolean test() {
        HttpRequest request = makeGet(STATUS_CALL);
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().equals("OK");
        } catch (IOException | InterruptedException ex) {
            return false;
        }
    }

}