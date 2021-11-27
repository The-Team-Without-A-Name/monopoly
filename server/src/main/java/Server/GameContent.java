package Server;

import library.Game;
import library.Player;

import java.util.List;
import java.util.Random;

/**
 * @author Madison May
 * We need to have a class to store the player information for te whole game.
 */
public class GameContent {

    private List<Player> playerList;
    private Game game;
    //private List<Game> gameList; //so that we could run multiple games in the future

    //this constructor is private, so it cannot be accessed outside this class
    private GameContent() {}

    /**
     * GameContent class that is static and final so that it cannot be manipulated outside this class because
     * the constructor is private.
     */
    public static final class GameContentInstance {
        private static final GameContent INSTANCE = new GameContent();
    }

    public static GameContent getInstance() {
        return GameContentInstance.INSTANCE;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Game getGame() {
        return game;
    }

    //This will have to be called before any of the other methods are usable.
    public void newGame(String playerID) {
        if (playerID != null) {
            Game game = new Game();
            game.addPlayer(findPlayer(playerID));
        }
    }
    public void newPlayer(String playerName) {
        if (game != null) {
            Player newPlayer = new Player(playerName);
            Random random = new Random();
            String newPlayerID = String.format("%04d", random.nextInt(10000));
            newPlayer.setPlayerID(newPlayerID);
            playerList.add(newPlayer);
            addPlayerToGame(newPlayerID);
        }
    }
    public void addPlayerToGame(String playerID) {
        if (game != null && playerID != null) {
            game.addPlayer(findPlayer(playerID));
        }
    }


    //This method could have much better search functionality: something to look into if we have time
    private Player findPlayer(String id) {
        for(Player player : playerList) {
            if (id == player.getPlayerID()) {
                return player;
            }
        }
        return null;
    }
}
