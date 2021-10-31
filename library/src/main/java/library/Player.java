package library;

/* This is a class for handling players in Monopoly game
For now, this class contains only the general methods and instances.
 */
public class Player {

    // private instances for player
    private String playerName;
    private int playerLocation;
    private int playerBudget;
    private String gamePiece;
    private boolean playerTurn=false;
    private boolean inPrison=false;

    //constructor
    public Player(String playerName){
        this.playerName=playerName;
    }

    //return player's name
    public String getPlayerName() {
        return playerName;
    }

    //return player location
    public int getPlayerLocation() {
        return playerLocation;
    }

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
    public void setPlayerLocation(int playerLocation) {
        this.playerLocation = playerLocation;
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
