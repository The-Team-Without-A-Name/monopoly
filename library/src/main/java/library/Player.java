package library;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

/** This is a class for handling players in Monopoly game
 * For now, this class contains only the general methods and instances.
 * create json for player location, money, propertiesowned, etc so gamestate can be updated.
 */

public class Player {

    // private instances for player
    private String playerName;
    //@lombok.Setter
    //private BoardLocation playerLocation;
    public static int playerBudget;
    private String gamePiece;
    private boolean playerTurn=false;
    public  boolean inPrison=false;
    public  boolean getOutOfJailFree = false;
    private int playerRow;
    private int playerColumn;

    //constructor
    public Player(String playerName){
        this.playerName=playerName;
        playerBudget = 2000;
    }
    public void CreatePlayer1JSON(Player player){
        try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("playerinfo.json"));

            //Create Map for White Space Properties
            Map<String, Object> player1 = new HashMap<>();
            player1.put("Name","Player1" );
            player1.put("Budget", 2000);
            player1.put("GetOutOfJail", false);
            player1.put("Properties", "Null");
            player1.put("Position X",0 );
            player1.put("Position Y",0 );

            Gson gson = new Gson();

            // write JSON to file
            writer.write(gson.toJson(player1));


            writer.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void CreatePlayer2JSON(Player player){
        try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("playerinfo.json"));

            //Create Map for White Space Properties
            Map<String, Object> player2 = new HashMap<>();
            player2.put("Name","Player2" );
            player2.put("Budget", 2000);
            player2.put("GetOutOfJail", false);
            player2.put("Properties", "Null");
            player2.put("Position X",0 );
            player2.put("Position Y",0 );

            Gson gson = new Gson();

            // write JSON to file
            writer.write(gson.toJson(player2));


            writer.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ReadGameState(String player1, String player2){

        try{

            //Create Reader
            Reader reader = Files.newBufferedReader(Paths.get("playerinfo.json"));

            //Create JsonObject Parser
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

            //read space details
            JsonObject p1 = parser.get(player1).getAsJsonObject();
            JsonObject p2 = parser.get(player2).getAsJsonObject();

            String name = parser.get("Name").getAsString();
            int price = parser.get("Budget").getAsInt();
            boolean isOwned = parser.get("GetOutOfJail").getAsBoolean();
            String set = parser.get("Properties").getAsString();
            int xpos = parser.get("Position X").getAsInt();
            int ypos = parser.get("Position y").getAsInt();


            //close reader
            reader.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //Player player1=new Player("FirstPlayer");
    //return player's name
    public String getPlayerName() {
        return playerName;
    }

    //return player location
    //public BoardLocation getPlayerLocation() {
    //    return playerLocation;
    //}

    //return playerBudget
    public int getPlayerBudget() {
        return playerBudget;
    }

    //return gamePiece
    public String getGamePiece() {
        return gamePiece;
    }

    //set player Name
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    //set player location
    public void setPlayerBudget(int playerBudget) {
        this.playerBudget = playerBudget;
    }

    //set game piece
    public void setGamePiece(String gamePiece) {
        this.gamePiece = gamePiece;
    }

    //set the player turn
    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    // returns true if player is in prison state
    public boolean isInPrison() {
        return inPrison;
    }

    //returns true if it is players turn
    public boolean isPlayerTurn() {
        return playerTurn;
    }

    //To-string if needed
    public String toString(){
        // returns null for now, will be changed later

        return null;
    }

    //check to see if player is bankrupt
    public boolean isBankrupt(){
        return playerBudget<=0;
    }

    //add property that player owns
    public void addProperty(){

        //add the new property owned to previously owned.
    }

    /*Contains other methods
    as required
     */





}
