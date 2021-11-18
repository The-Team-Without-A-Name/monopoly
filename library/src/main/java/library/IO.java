package library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/** @author Madison May */

public class IO {

  private static final String saveLocation = "src/main/resources/gameState.json";

  public IO() {

  }

  /** @author Madison May
   * Writes a Gamestate object to the gameState.json file in the resources folder
   * @param gameState  GameState object to write */

  public void SaveGameStateToJson(GameState gameState) {
    try {
      Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
      String json = gsonBuilder.toJson(gameState);

      FileWriter writer = new FileWriter(saveLocation);
      writer.write(json);

      writer.close();

    } catch (IOException e) {
      System.out.println("IO Exception on file write.");
      e.printStackTrace();
    }
  }

  /** @author Madison May
   * reads from the file location and returns a gamestate
   * If the gamestate needs to be saved in a different place, this method can easily be refactored to take in a
   * sting parameter for the file location */
  public GameState LoadGameStateFromJson() {
    try {
      Gson gson = new Gson();

      FileReader fileReader = new FileReader(saveLocation);

      return gson.fromJson(fileReader, GameState.class);


    } catch (FileNotFoundException e) {
      System.out.println("IO Exception of file read.");
      e.printStackTrace();
      return null;
    }
  }
}
