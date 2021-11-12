package Client;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import library.Dice;
import library.Player;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;


/**
 * @author Madison May
 * GameBoardController contains FXML objects, buttons, and methods.
 * Sets up how the player moves along with the dice roll.
 */

public class GameBoardController {

    //The location for the images, that can potentially come from any set of images
    private final String resource = "src/main/resources/Client/";

    private final String classicThemeLocation = "classicMonopoly/";
    private final String basicThemeLocation = "basicMonopoly/";


    //This image was used for testing purpose. May be used later because it was beautiful.
    private final String frog = "src/main/resources/Client/" + classicThemeLocation + "/frog.jpg";

    private MonopolyClient app;

    //FXML objects
    @FXML
    private GridPane gameBoard;

    @FXML
    private ChoiceBox themeBox;


    /*
     Player 1's things
     */
    @FXML
    private Label p1DiceLabel;

    @FXML
    private VBox p1ButtonBox;

    @FXML
    private Rectangle p1Piece;


    /*
     Player 2's things
     */
    @FXML
    private Label p2DiceLabel;

    @FXML
    private VBox p2ButtonBox;

    @FXML
    private Rectangle p2Piece;




    /*
     * I'm sure there's a more efficient way to do this, but I do not know it. I am going to have to manually make a
     * Rectangle for each square that can be manipulated by this controller.
     */
    @FXML
    private Rectangle Go;
    @FXML
    private Rectangle MedAve;
    @FXML
    private Rectangle CommunityChest1;
    @FXML
    private Rectangle BalAve;
    @FXML
    private Rectangle IncomeTax;
    @FXML
    private Rectangle ReadingRailroad;
    @FXML
    private Rectangle OriAve;
    @FXML
    private Rectangle Chance1;
    @FXML
    private Rectangle VerAve;
    @FXML
    private Rectangle ConAve;
    @FXML
    private Rectangle Jail;
    @FXML
    private Rectangle StChaPla;
    @FXML
    private Rectangle ElectricCompany;
    @FXML
    private Rectangle StaAve;
    @FXML
    private Rectangle VirAve;
    @FXML
    private Rectangle PennsylvaniaRailroad;
    @FXML
    private Rectangle StJamPla;
    @FXML
    private Rectangle CommunityChest2;
    @FXML
    private Rectangle TenAve;
    @FXML
    private Rectangle NewAve;
    @FXML
    private Rectangle FreeParking;
    @FXML
    private Rectangle KenAve;
    @FXML
    private Rectangle Chance2;
    @FXML
    private Rectangle IndAve;
    @FXML
    private Rectangle IllAve;
    @FXML
    private Rectangle BORailroad;
    @FXML
    private Rectangle AtlAve;
    @FXML
    private Rectangle VenAve;
    @FXML
    private Rectangle WaterWorks;
    @FXML
    private Rectangle MarvinGardens;
    @FXML
    private Rectangle GoToJail;
    @FXML
    private Rectangle PacAve;
    @FXML
    private Rectangle NorAve;
    @FXML
    private Rectangle CommunityChest3;
    @FXML
    private Rectangle PenAve;
    @FXML
    private Rectangle ShortLine;
    @FXML
    private Rectangle Chance3;
    @FXML
    private Rectangle ParPla;
    @FXML
    private Rectangle LuxuryTax;
    @FXML
    private Rectangle BoardWalk;

////<<<<<<< Updated upstream
 //   private Player player1;
  //  private Player player2;

    private Dice dice;

//=======
    //private Player player1;
Player player1 = new Player("player1");
Player player2 = new Player("player2");
//>>>>>>> Stashed changes

    public GameBoardController(MonopolyClient app) throws FileNotFoundException { this.app = app;}

    //FXML button methods
    @FXML
    protected void onStartButtonClick() throws FileNotFoundException {

        if (!gameBoard.getChildren().contains(p1Piece)) {
            gameBoard.add(p1Piece, 10, 10);
            gameBoard.add(p2Piece, 10, 10);
            gameBoard.setHalignment(p1Piece, HPos.CENTER);
            gameBoard.setValignment(p1Piece, VPos.CENTER);

            gameBoard.setHalignment(p2Piece, HPos.CENTER);
            gameBoard.setValignment(p2Piece, VPos.CENTER);
        }
        setTheme(resource + basicThemeLocation);
    }
//<<<<<<< Updated upstream
//=======
    @FXML
    protected void onMoveButtonClick() {
        //player2.Create(player2);
        //move for some input from server
        //Move(4);
    }
//>>>>>>> Stashed changes


    @FXML
    //need to add a way to accept a player object and call diceroll, then use the returned value from diceroll to update movement and print the #
    protected void onP1DiceButtonClick() throws InterruptedException {

        //Need to send dice roll request to server
        int diceVal = dice.roll(player1);
        p1DiceLabel.setText("Dice rolled: %d".formatted(diceVal));
        Move(diceVal, p1Piece);

    }

    @FXML
    protected void onP2DiceButtonClick() throws InterruptedException {

        //Need to send dice roll request to server
        int diceVal = dice.roll(player2);
        p2DiceLabel.setText("Dice rolled: %d".formatted(diceVal));
        Move(diceVal, p2Piece);

    }
    @FXML
    protected void onP1PropertyPurchase() throws InterruptedException, IOException, ParseException {

        JSONObject value;
        try (Reader in = new InputStreamReader(getClass().getResourceAsStream("/playerinfo.json"))) {
            JSONParser parser = new JSONParser();
            value = (JSONObject) parser.parse(in);
        }
        JSONObject player1obj = (JSONObject) value.get("player1");

        // update properties
        String propertyname = player1.getPosition;
        player1obj.put("Properties", propertyname);
        // need to update budget as well as assign that property a true isOwned bool

        // write to playerinfo file
        try (Writer out = new FileWriter("playerinfo.json")) {
            out.write(value.toJSONString());
        }

    }
    /*
     * This method is meant to set the theme to classic Monopoly and make it possible for later sprints
     * to set up a theme-choose when you launch the game.
     */
    @FXML
    protected void setTheme(String themeFolder) throws FileNotFoundException {
        Go.setFill(getImageFill(themeFolder + "Go.png"));
        MedAve.setFill(getImageFill(themeFolder + "MediterraneanAvenue.png"));
        CommunityChest1.setFill(getImageFill(themeFolder + "CommunityChest.png"));
        BalAve.setFill(getImageFill(themeFolder + "BalticAvenue.png"));
        IncomeTax.setFill(getImageFill(themeFolder + "IncomeTax.png"));
        ReadingRailroad.setFill(getImageFill(themeFolder + "ReadingRailroad.png"));
        OriAve.setFill(getImageFill(themeFolder + "OrientalAvenue.png"));
        Chance1.setFill(getImageFill(themeFolder + "Chance.png"));
        VerAve.setFill(getImageFill(themeFolder + "VermontAvenue.png"));
        ConAve.setFill(getImageFill(themeFolder + "ConnecticutAvenue.png"));
        Jail.setFill(getImageFill(themeFolder + "Jail.png"));
        StChaPla.setFill(getImageFill(themeFolder + "StCharlesPlace.png"));
        ElectricCompany.setFill(getImageFill(themeFolder + "ElectricCompany.png"));
        StaAve.setFill(getImageFill(themeFolder + "StatesAvenue.png"));
        VirAve.setFill(getImageFill(themeFolder + "VirginiaAvenue.png"));
        PennsylvaniaRailroad.setFill(getImageFill(themeFolder + "PennsylvaniaRailroad.png"));
        StJamPla.setFill(getImageFill(themeFolder + "StJamesPlace.png"));
        CommunityChest2.setFill(getImageFill(themeFolder + "CommunityChest2.png"));
        TenAve.setFill(getImageFill(themeFolder + "TennesseeAvenue.png"));
        NewAve.setFill(getImageFill(themeFolder + "NewYorkAvenue.png"));
        FreeParking.setFill(getImageFill(themeFolder + "FreeParking.png"));
        KenAve.setFill(getImageFill(themeFolder + "KentuckyAvenue.png"));
        Chance2.setFill((getImageFill(themeFolder + "Chance2.png")));
        IndAve.setFill(getImageFill(themeFolder + "IndianaAvenue.png"));
        IllAve.setFill(getImageFill(themeFolder + "IllinoisAvenue.png"));
        BORailroad.setFill(getImageFill(themeFolder + "BORailroad.png"));
        AtlAve.setFill(getImageFill(themeFolder + "AtlanticAvenue.png"));
        VenAve.setFill(getImageFill(themeFolder + "VentnorAvenue.png"));
        WaterWorks.setFill(getImageFill(themeFolder + "WaterWorks.png"));
        MarvinGardens.setFill(getImageFill(themeFolder + "MarvinGardens.png"));
        GoToJail.setFill(getImageFill(themeFolder + "GoToJail.png"));
        PacAve.setFill(getImageFill(themeFolder + "PacificAvenue.png"));
        NorAve.setFill(getImageFill(themeFolder + "NorthCarolinaAvenue.png"));
        CommunityChest3.setFill(getImageFill(themeFolder + "CommunityChest3.png"));
        PenAve.setFill(getImageFill(themeFolder + "PennsylvaniaAvenue.png"));
        ShortLine.setFill(getImageFill(themeFolder + "ShortLine.png"));
        Chance3.setFill(getImageFill(themeFolder + "Chance3.png"));
        ParPla.setFill(getImageFill(themeFolder + "ParkPlace.png"));
        LuxuryTax.setFill(getImageFill(themeFolder + "LuxuryTax.png"));
        BoardWalk.setFill(getImageFill(themeFolder + "Boardwalk.png"));


    }

    //Regular internal methods
    protected ImagePattern getImageFill(String image) throws FileNotFoundException {
        return new ImagePattern(new Image(new FileInputStream(image)));
    }
    protected void Move(int movement, Rectangle piece) throws InterruptedException {
        if (gameBoard.getChildren().contains(piece)) {
            for(int i = 0; i < movement; i++) {
                int column = GridPane.getColumnIndex(piece);
                int row = GridPane.getRowIndex(piece);

                if (onTopRow(column, row)) GridPane.setColumnIndex(piece, column + 1);
                if (onBottomRow(column, row)) GridPane.setColumnIndex(piece, column - 1);
                if (onRightColumn(column, row)) GridPane.setRowIndex(piece, row + 1);
                if (onLeftColumn(column, row)) GridPane.setRowIndex(piece, row - 1);
                GridPane.setHalignment(piece, HPos.CENTER);
                GridPane.setValignment(piece, VPos.CENTER);


            }
        }
    }
//    protected void SetThemeBox() {
//        themeBox.
//    }

    protected boolean onTopRow(int column, int row) {
        return row == 0 && column != 10;
    }
    protected boolean onBottomRow(int column, int row) {
        return row == 10 && column != 0;
    }
    protected boolean onLeftColumn(int column, int row) {
        return column == 0 && row != 0;
    }
    protected boolean onRightColumn(int column, int row) {
        return column == 10 && row != 10;
    }

    private void initGameBoard() {

    }
}
