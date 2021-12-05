package clientTest;


import Client.Connection;
import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import library.GameState;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;


/**
 * Class for testing all the connection related logics in client
 */
public class ClientTest {

    static Connection connection = Connection.instance();


    // Before the tests, initialize the connection
    @BeforeAll
    static void initializeConnection() {

        connection.initialize("localhost", "7000");
   }

   // After the  tests, disconnect to the server
    @AfterAll
    static void disconnectConnection() {

        connection.disconnect();
    }

    // test the initialize method
    @Test
    public void testIsInitialized() {
        //initialized boolean is private so cannot call here
       // Assertions.assertTrue(connection.initialized);
  }

    // test the test method
   @Test
    public void testTest() {

        Assertions.assertTrue(connection.test());

   }

   @Test
    public void testGet() throws IOException, InterruptedException {
       HttpResponse<JsonNode> response = Unirest.get("http://localhost:7000/api/get-gamestate").asJson();
       String data = response.getBody().toString();
       GameState gameState = new Gson().fromJson(data, GameState.class);
       Assertions.assertNotNull(gameState);
       Assertions.assertNotNull(connection.GetGameState());
       Assertions.assertEquals(gameState,connection.GetGameState());
       Assertions.assertEquals(gameState.getPlayer1().getPlayerBudget(),connection.GetGameState().getPlayer1().getPlayerBudget());
   }

   /**
    * Reference: http://kong.github.io/unirest-java/#requests
    */

}

