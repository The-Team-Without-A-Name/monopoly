package Client;

import java.net.http.HttpClient;
import java.time.Duration;

public class Connection {

    private String address;
    private String port;
    private boolean initialize=false;
    private HttpClient client;


    //default constructor
    public Connection(){
    }

    //initialize
    public void initialize(String address,String port){
        this.address=address;
        this.port=port;
        initialize=true;

        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
    }

    //disconnect setting instances to null
    public void disconnect() {
        address = null;
        port = null;
        client = null;
    }

    public boolean isInitialize() {
        return initialize;
    }
}
