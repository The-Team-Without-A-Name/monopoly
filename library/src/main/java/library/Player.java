package library;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;
import lombok.Setter;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a class for handling players in Monopoly game For now, this class contains only the
 * general methods and instances. create json for player location, money, propertiesowned, etc so
 * gamestate can be updated.
 */
public class Player {

  private String playerName;

  @Getter @Setter
  private int playerBudget;

  @Getter @Setter
  private boolean playerTurn = false;

  @Getter @Setter
  public boolean inPrison = false;

  @Getter @Setter
  public boolean getOutOfJailFree = false;

  /** I decided to use this built-in java library, Point,  to store the position. It is pretty simple, and I will have to
   * reconfigure the GameBoardController, but I think it will be helpful
   * */
  @Getter @Setter
  private Point position;

  @Getter
  private ArrayList<Space> properties;





  // constructor
  public Player(String playerName) {
    this.playerName = playerName;
    playerBudget = 1500; //Starting dollar amount for standard Monopoly game
    position = new Point(10, 10);
    properties = new ArrayList<>();
  }



  /** @author Madison May
   * Checks to see if the Player is bancrupt*/
  public boolean isBankrupt() {
    return playerBudget <= 0;
  }

  /** @author Madison May
   * This method will add a Property to the player's property list
   * @param property: the property to be added to the list
   * */
  public void addProperty(Space property) {
    properties.add(property);
  }



}







// Here is all the stuff Rowan wrote before that I don't think we actually need */

//  public void CreatePlayer1JSON(Player player) {
//    try {
//      BufferedWriter writer = Files.newBufferedWriter(Paths.get("playerinfo.json"));
//
//      // Create Map for White Space Properties
//      Map<String, Object> player1obj = new HashMap<>();
//      player1obj.put("Name", "Player1");
//      player1obj.put("Budget", 2000);
//      player1obj.put("GetOutOfJail", false);
//      player1obj.put("Properties", "Null");
//      player1obj.put("Position X", 0);
//      player1obj.put("Position Y", 0);
//
//      Gson gson = new Gson();
//
//      // write JSON to file
//      writer.write(gson.toJson(player1obj));
//
//      writer.close();
//
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//  }
//
//  public void CreatePlayer2JSON(Player player) {
//    try {
//      BufferedWriter writer = Files.newBufferedWriter(Paths.get("playerinfo.json"));
//
//      // Create Map for White Space Properties
//      Map<String, Object> player2obj = new HashMap<>();
//      player2obj.put("Name", "Player2");
//      player2obj.put("Budget", 2000);
//      player2obj.put("GetOutOfJail", false);
//      player2obj.put("Properties", "Null");
//      player2obj.put("Position X", 0);
//      player2obj.put("Position Y", 0);
//
//      Gson gson = new Gson();
//
//      // write JSON to file
//      writer.write(gson.toJson(player2obj));
//
//      writer.close();
//
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//  }


//public void ReadGameState(String player1, String player2) {
//
//    try {
//
//      // Create Reader
//      Reader reader = Files.newBufferedReader(Paths.get("playerinfo.json"));
//
//      // Create JsonObject Parser
//      JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
//
//      // read space details
//      JsonObject p1 = parser.get(player1).getAsJsonObject();
//      JsonObject p2 = parser.get(player2).getAsJsonObject();
//
//      String name = parser.get("Name").getAsString();
//      int price = parser.get("Budget").getAsInt();
//      boolean isOwned = parser.get("GetOutOfJail").getAsBoolean();
//      String set = parser.get("Properties").getAsString();
//      int xpos = parser.get("Position X").getAsInt();
//      int ypos = parser.get("Position y").getAsInt();
//
//      // close reader
//      reader.close();
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//  }