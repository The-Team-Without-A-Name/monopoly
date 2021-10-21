import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;



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

