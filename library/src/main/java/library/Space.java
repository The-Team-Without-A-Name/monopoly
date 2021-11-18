package library;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Space class sets up the difference spaces on the board. Properties of the spaces are defined
 * (name, owned/not owned, price, and rent price).
 *
 * <p>Need to add different Sections for Go space, and Go To Jail Space.
 */
public class Space {

  protected String spaceName;
  protected int price;
  protected int rent;
  protected boolean owned;
  protected Player owner;

  /*   Not sure if we need these:
  private int playerLocation;
  private int landOn;

   */
  // default constructor
  Space() {}

  // constructor
  public Space(String spaceName, int price, int rent, boolean owned, Player player) {

    this.spaceName = spaceName;
    this.price = price;
    this.rent = price;
    this.owned = owned;
    this.owner = player;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getRent() {
    return rent;
  }

  public void setRent(int rent) {
    this.rent = rent;
  }

  public boolean isOwned() {
    return owned;
  }

  public void setOwned(boolean owned) {
    this.owned = owned;
  }

  public String getSpaceName() {
    return spaceName;
  }

  public void setSpaceName(String spaceName) {
    this.spaceName = spaceName;
  }

  public Player getOwner() {
    return owner;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

  // JSON READER AND WRITER.
  private void CreateJson() {

    try {
      BufferedWriter writer = Files.newBufferedWriter(Paths.get("monopoly.json"));

      // Create Map for White Space Properties
      Map<String, Object> connavespace = new HashMap<>();
      connavespace.put("Name", "Connecticut Avenue");
      connavespace.put("Price", 120);
      connavespace.put("IsOwned", false);
      connavespace.put("Set", "White");

      Map<String, Object> vermavespace = new HashMap<>();
      vermavespace.put("Name", "Vermont Avenue");
      vermavespace.put("Price", 100);
      vermavespace.put("IsOwned", false);
      vermavespace.put("Set", "White");

      Map<String, Object> orienavespace = new HashMap<>();
      orienavespace.put("Name", "Oriental Avenue");
      orienavespace.put("Price", 100);
      orienavespace.put("IsOwned", false);
      orienavespace.put("Set", "White");

      // Create Map for Brown Space Properties
      Map<String, Object> balticavespace = new HashMap<>();
      balticavespace.put("Name", "Baltic Avenue");
      balticavespace.put("Price", 60);
      balticavespace.put("IsOwned", false);
      balticavespace.put("Set", "Brown");

      Map<String, Object> meditavespace = new HashMap<>();
      meditavespace.put("Name", "Mediterranean Avenue");
      meditavespace.put("Price", 60);
      meditavespace.put("IsOwned", false);
      meditavespace.put("Set", "Brown");

      // Create Map for Blue Space Properties
      Map<String, Object> boardwalkspace = new HashMap<>();
      boardwalkspace.put("Name", "Boardwalk");
      boardwalkspace.put("Price", 400);
      boardwalkspace.put("IsOwned", false);
      boardwalkspace.put("Set", "Blue");

      Map<String, Object> parkplacespace = new HashMap<>();
      parkplacespace.put("Name", "Park Place");
      parkplacespace.put("Price", 350);
      parkplacespace.put("IsOwned", false);
      parkplacespace.put("Set", "Blue");

      // Create Map for Green Space Properties
      Map<String, Object> pensavespace = new HashMap<>();
      pensavespace.put("Name", "Pennsylvania Avenue");
      pensavespace.put("Price", 320);
      pensavespace.put("IsOwned", false);
      pensavespace.put("Set", "Green");

      Map<String, Object> ncarolinaspace = new HashMap<>();
      ncarolinaspace.put("Name", "North Carolina Avenue");
      ncarolinaspace.put("Price", 300);
      ncarolinaspace.put("IsOwned", false);
      ncarolinaspace.put("Set", "Green");

      Map<String, Object> pacificavespace = new HashMap<>();
      pacificavespace.put("Name", "Pacific Avenue");
      pacificavespace.put("Price", 300);
      pacificavespace.put("IsOwned", false);
      pacificavespace.put("Set", "Green");

      // Create Map for Yellow Space Properties
      Map<String, Object> marvingardensspace = new HashMap<>();
      marvingardensspace.put("Name", "Marvin Gardens");
      marvingardensspace.put("Price", 280);
      marvingardensspace.put("IsOwned", false);
      marvingardensspace.put("Set", "Yellow");

      Map<String, Object> ventnoravespace = new HashMap<>();
      ventnoravespace.put("Name", "Ventnor Avenue");
      ventnoravespace.put("Price", 260);
      ventnoravespace.put("IsOwned", false);
      ventnoravespace.put("Set", "Yellow");

      Map<String, Object> atlanticavespace = new HashMap<>();
      atlanticavespace.put("Name", "Atlantic Avenue");
      atlanticavespace.put("Price", 260);
      atlanticavespace.put("IsOwned", false);
      atlanticavespace.put("Set", "Yellow");

      // Create Map for Red Space Properties
      Map<String, Object> illinoisavespace = new HashMap<>();
      illinoisavespace.put("Name", "Illinois Avenue");
      illinoisavespace.put("Price", 240);
      illinoisavespace.put("IsOwned", false);
      illinoisavespace.put("Set", "Red");

      Map<String, Object> indianavespace = new HashMap<>();
      indianavespace.put("Name", "Indian Avenue");
      indianavespace.put("Price", 220);
      indianavespace.put("IsOwned", false);
      indianavespace.put("Set", "Red");

      Map<String, Object> kentuckyavespace = new HashMap<>();
      kentuckyavespace.put("Name", "Indian Avenue");
      kentuckyavespace.put("Price", 220);
      kentuckyavespace.put("IsOwned", false);
      kentuckyavespace.put("Set", "Red");

      // Create Map for Orange Space Properties
      Map<String, Object> newyorkavespace = new HashMap<>();
      newyorkavespace.put("Name", "New York Avenue");
      newyorkavespace.put("Price", 200);
      newyorkavespace.put("IsOwned", false);
      newyorkavespace.put("Set", "Orange");

      Map<String, Object> tenneseeavespace = new HashMap<>();
      tenneseeavespace.put("Name", "Tennessee Avenue");
      tenneseeavespace.put("Price", 180);
      tenneseeavespace.put("IsOwned", false);
      tenneseeavespace.put("Set", "Orange");

      Map<String, Object> stjamesplacespace = new HashMap<>();
      stjamesplacespace.put("Name", "St. James Place");
      stjamesplacespace.put("Price", 180);
      stjamesplacespace.put("IsOwned", false);
      stjamesplacespace.put("Set", "Orange");

      // Create Map for Pink Space Properties
      Map<String, Object> virginavespace = new HashMap<>();
      virginavespace.put("Name", "Virginia Avenue");
      virginavespace.put("Price", 160);
      virginavespace.put("IsOwned", false);
      virginavespace.put("Set", "Pink");

      Map<String, Object> statesavespace = new HashMap<>();
      statesavespace.put("Name", "States Avenue");
      statesavespace.put("Price", 140);
      statesavespace.put("IsOwned", false);
      statesavespace.put("Set", "Pink");

      Map<String, Object> stcharlesplacespace = new HashMap<>();
      stcharlesplacespace.put("Name", "St. Charles Place");
      stcharlesplacespace.put("Price", 140);
      stcharlesplacespace.put("IsOwned", false);
      stcharlesplacespace.put("Set", "Pink");

      // Create Map for RailRoad Space Properties
      Map<String, Object> readingrailroad = new HashMap<>();
      readingrailroad.put("Name", "Reading Railroad");
      readingrailroad.put("Price", 200);
      readingrailroad.put("IsOwned", false);
      readingrailroad.put("Set", "Railroad");

      Map<String, Object> shortline = new HashMap<>();
      shortline.put("Name", "Short Line");
      shortline.put("Price", 200);
      shortline.put("IsOwned", false);
      shortline.put("Set", "Railroad");

      Map<String, Object> borailroad = new HashMap<>();
      borailroad.put("Name", "B&O Railroad");
      borailroad.put("Price", 200);
      borailroad.put("IsOwned", false);
      borailroad.put("Set", "Railroad");

      Map<String, Object> pennsylvrailroad = new HashMap<>();
      pennsylvrailroad.put("Name", "Pennsylvania Railroad");
      pennsylvrailroad.put("Price", 200);
      pennsylvrailroad.put("IsOwned", false);
      pennsylvrailroad.put("Set", "Railroad");

      // Create Map for special Space Properties
      Map<String, Object> electriccom = new HashMap<>();
      electriccom.put("Name", "Reading Railroad");
      electriccom.put("Price", 200);
      electriccom.put("IsOwned", false);
      electriccom.put("Set", "Special");

      Map<String, Object> waterworks = new HashMap<>();
      waterworks.put("Name", "Short Line");
      waterworks.put("Price", 150);
      waterworks.put("IsOwned", false);
      waterworks.put("Set", "Special");

      // create Gson instance
      Gson gson = new Gson();

      // write JSON to file
      writer.write(gson.toJson(connavespace));
      writer.write(gson.toJson(vermavespace));
      writer.write(gson.toJson(orienavespace));
      writer.write(gson.toJson(balticavespace));
      writer.write(gson.toJson(meditavespace));
      writer.write(gson.toJson(boardwalkspace));
      writer.write(gson.toJson(parkplacespace));
      writer.write(gson.toJson(pensavespace));
      writer.write(gson.toJson(ncarolinaspace));
      writer.write(gson.toJson(pacificavespace));
      writer.write(gson.toJson(marvingardensspace));
      writer.write(gson.toJson(ventnoravespace));
      writer.write(gson.toJson(atlanticavespace));
      writer.write(gson.toJson(illinoisavespace));
      writer.write(gson.toJson(indianavespace));
      writer.write(gson.toJson(kentuckyavespace));
      writer.write(gson.toJson(newyorkavespace));
      writer.write(gson.toJson(tenneseeavespace));
      writer.write(gson.toJson(stjamesplacespace));
      writer.write(gson.toJson(virginavespace));
      writer.write(gson.toJson(statesavespace));
      writer.write(gson.toJson(stcharlesplacespace));
      writer.write(gson.toJson(readingrailroad));
      writer.write(gson.toJson(shortline));
      writer.write(gson.toJson(borailroad));
      writer.write(gson.toJson(pennsylvrailroad));
      writer.write(gson.toJson(electriccom));
      writer.write(gson.toJson(waterworks));

      // close the writer
      writer.close();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void ReadJson(String propertyname) {

    try {

      // Create Reader
      Reader reader = Files.newBufferedReader(Paths.get("monopoly.json"));

      // Create JsonObject Parser
      JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

      // read space details
      JsonObject space = parser.get(propertyname).getAsJsonObject();

      String name = parser.get("Name").getAsString();
      int price = parser.get("Price").getAsInt();
      boolean isOwned = parser.get("IsOwned").getAsBoolean();
      String set = parser.get("Set").getAsString();

      // close reader
      reader.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
