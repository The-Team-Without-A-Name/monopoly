package clientTest;

import Client.Connection;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectionTest {

    //Connection instance to test
    private static Connection connection = new Connection();

    @BeforeAll
    private static void initializeConnection() {
        connection.initialize("address?", "7000");
    }

    @AfterAll
    private static void disconnectConnection() {
        connection.disconnect();
    }

    @Test
    private static void testTest() {
        assertEquals(1, 1);
    }
}
