package libraryTest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import library.Player;
import library.Space;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SpaceTest {
    Player henry =new Player("Henry");

    Space space=new Space("P",100,10,false,henry);
    Gson gson=new Gson();

    @Test
    public void testCreateJason() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("monopoly.json"));
        Gson gson = new Gson();
        writer.write(gson.toJson(space));  //
        Assertions.assertNotNull(writer);
        writer.close();

    }

    String propertyName ="firstProperty";



    //I am not sure about how to write test for this

 /*   @Test
    public void testReadJason() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("monopoly.json"));
        JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
        JsonObject space = parser.get(propertyName).getAsJsonObject();
        Assertions.assertEquals(parser.get("Name").getAsString(),"P");
        Assertions.assertEquals(parser.get("Price").getAsInt(),100);
        Assertions.assertEquals(parser.get("IsOwned").getAsBoolean(),false);
        Assertions.assertEquals(parser.get("Set").getAsString(),"Henry");
        reader.close();

  */


    }



