package libraryTest;

import com.google.gson.Gson;
import library.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PlayerTest {
  Player testPlayer = new Player("testPlayer");

<<<<<<< HEAD
  @Test
  public void isNotBancrupt() {
    Assertions.assertFalse(testPlayer.isBankrupt());
  }

  @Test
  public void isNotInPrison() {
    Assertions.assertFalse(testPlayer.isInPrison());
  }
=======
    @Test
    public void isNotBancrupt() {
        Assertions.assertFalse(testPlayer.isBankrupt());
    }
    @Test
    public void isNotInPrison() {
        Assertions.assertFalse(testPlayer.isInPrison());
    }

  /*  @Test
    public void testCreatePlayer1JSON(){
        try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("playerinfo.json"));
            Map<String, Object> obj = new HashMap<>();
            obj.put("Name","Player1" );
            obj.put("Budget", 2000);
            obj.put("GetOutOfJail", false);
            obj.put("Properties", "Null");

            Gson gson = new Gson();

            // write JSON to file
            Assertions.assertNotNull(writer.write(gson.toJson(obj)));
            writer.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    
   */
>>>>>>> c2780d6c940e677cdc2114e685bfd54989bc3e0e
}
