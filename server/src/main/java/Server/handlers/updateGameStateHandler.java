package Server.handlers;

import Server.GameContent;
import com.google.gson.Gson;
import library.Player;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Rowan Murphy
 * Gamestate update methods
 * Still working to get it communicating with the server.
 */

public class updateGameStateHandler extends BasicHandler{
    public updateGameStateHandler(GameContent content) {
        super(content);
    }

    private String gameID;

    public static Map<String, Object> updateGameStates(@NotNull Player player, Player player2) throws IOException {



        BufferedWriter writer = Files.newBufferedWriter(Paths.get("Gamestate.json"));
        //int playerID = player.getPlayerID();
        Map<String, Object> Gamestate = new HashMap<>();


        //if(playerID == 1) {
//Map<String, Object> Gamestate = new HashMap<>();
        try {
            Gamestate.put("p1Budget", player.getPlayerBudget());
            Gamestate.put("p1Position", player.getPosition());
            Gamestate.put("p1Properties", player.getProperties());
            Gamestate.put("p1isTurn", player.isPlayerTurn());
            Gamestate.put("p1Jail", player.isInPrison());
            Gamestate.put("p1goojf", player.isGetOutOfJailFree());

            Gamestate.put("p2Budget", player2.getPlayerBudget());
            Gamestate.put("p2Position", player2.getPosition());
            Gamestate.put("p2Properties", player2.getProperties());
            Gamestate.put("p2isTurn", player2.isPlayerTurn());
            Gamestate.put("p2Jail", player2.isInPrison());
            Gamestate.put("p2goojf", player2.isGetOutOfJailFree());


            Gson gson = new Gson();

            writer.write(gson.toJson(Gamestate));

            writer.close();
        }catch (IOException ex) {
                ex.printStackTrace();
            }


            return Gamestate;
        //}
       /* else{
            //Map<String, Object> p2Gamestate = new HashMap<>();
            Gamestate.put("p2Budget", player2.getPlayerBudget());
            Gamestate.put("p2Position", player2.getPosition());
            Gamestate.put("p2Properties", player2.getProperties());
            Gamestate.put("p2isTurn", player2.isPlayerTurn());
            Gamestate.put("p2Jail", player2.isInPrison());
            Gamestate.put("p2goojf", player2.isGetOutOfJailFree());


            Gson gson = new Gson();

            writer.write(gson.toJson(Gamestate));

            writer.close();
            return Gamestate;
        }
        */
    }

    @Override
    public void processData(Map<String, String> data) {
        gameID = data.get("gameID");
    }

    @Override
    public Object getMessage() {
        return null;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
