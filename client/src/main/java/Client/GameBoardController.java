package Client;

import com.google.gson.Gson;
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
import library.Game;
import library.Player;
import library.Space;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.Objects;


/**
 * @author Madison May
 * GameBoardController contains FXML objects, buttons, and methods.
 * Sets up how the player moves along with the dice roll.
 */

public class GameBoardController {
    private static final String p1ID = "Monopoly-Player1-ID";
    private static final String p2ID = "Monopoly-Player2-ID";

    private final String resource = "src/main/resources/Client/";

    private final String classicThemeLocation = "classicMonopoly/";
    private final String basicThemeLocation = "basicMonopoly/";
    private final String spaceLocation = resource + "spaces.json";


    //This image was used for testing purpose. May be used later because it was beautiful.
    private final String frog = "src/main/resources/Client/" + classicThemeLocation + "/frog.jpg";

    private Space[] spaceArray;
    private MonopolyClient app;
    private Game game;
    private Connection connection;

    /** FXML objects */
    @FXML
    private GridPane gameBoard;

    @FXML
    private ChoiceBox themeBox;


    /**
     Player 1's things
     */
    @FXML
    private Label p1DiceLabel;

    @FXML
    private VBox p1ButtonBox;

    @FXML
    private Rectangle p1Piece;


    /**
     Player 2's things
     */
    @FXML
    private Label p2DiceLabel;

    @FXML
    private VBox p2ButtonBox;

    @FXML
    private Rectangle p2Piece;




    /**
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

    @FXML
    private Label properties;

    @FXML
    private Label funding;


    private Player player1;
    private Player player2;
    private Dice dice;

    //I don't think we will actually store any Player objects in here. I am going to store the player information as an id specific to player 1 and player 2


    public GameBoardController(MonopolyClient app) throws FileNotFoundException {
        this.app = app;
    }


    protected void InitializeGame() throws FileNotFoundException {

        Game game = new Game();
        //TODO: update game state here
        if (!gameBoard.getChildren().contains(p1Piece)) {
            gameBoard.add(p1Piece, 10, 10);
            gameBoard.add(p2Piece, 10, 10);
            gameBoard.setHalignment(p1Piece, HPos.CENTER);
            gameBoard.setValignment(p1Piece, VPos.CENTER);

            gameBoard.setHalignment(p2Piece, HPos.CENTER);
            gameBoard.setValignment(p2Piece, VPos.CENTER);

        }
        setTheme(resource + basicThemeLocation);
        spaceArray = loadSpaces();
        //TODO: make this come from the server if Rowan ever gets it done
        player1 = new Player("P1");
        player1.setPlayerTurn(true);
        app.showWarningDialog("Welcome to the game.",  String.format("You are player %s", player1.getPlayerName()));
        updateProperties();
    }


    private void updateProperties() {
        String values = "";
        for (Space property : player1.getProperties()) {
            values += property.getSpaceName() + "\n";
        }
        properties.setText(values);
        funding.setText(String.valueOf(player1.getPlayerBudget()));
    }
    //FXML button methods
    @FXML
    protected void onP1DiceButtonClick() throws InterruptedException, IOException {

        if(player1.isPlayerTurn()) {

            int diceVal = Dice.roll(player1);
            p1DiceLabel.setText("%d".formatted(diceVal));
            Move(diceVal, p1Piece);
            Space landedOn = getSpace();
            if (landedOn.isCanBePurchased()) {
                boolean choice = app.showMessage(landedOn.getSpaceName(), "You have landed on: %s".formatted(landedOn.getSpaceName()));
                if (choice) {
                    if (player1.getPlayerBudget() >= landedOn.getPrice() && landedOn.isCanBePurchased()) {
                        buyProperty(landedOn);

                    } else if (player1.getPlayerBudget() < landedOn.getPrice()) {
                        app.showWarningDialog("Not Allowed", "You cannot purchase this property because you do not have the proper funds.");
                    }
                }

            } else if (!landedOn.isCanBePurchased() && landedOn.isOwned()) {
                app.showWarningDialog(landedOn.getSpaceName(), "This space is owned! \n You landed on %s. ".formatted(landedOn.getSpaceName()) +
                        "You must pay $%d to the player that owns this property.".formatted(landedOn.getRent()));
                if (player1.getPlayerBudget() > landedOn.getRent()) {
                    player1.setPlayerBudget(player1.getPlayerBudget() - landedOn.getRent());
                } else {
                    player1.setPlayerBudget(0);
                }
            } else if (!landedOn.isCanBePurchased() && !landedOn.isOwned() && !landedOn.isDrawsCard()) {
                app.showWarningDialog(landedOn.getSpaceName(), "You landed on %s. ".formatted(landedOn.getSpaceName()) +
                        "You must pay $%d.".formatted(landedOn.getRent()));
                if (player1.getPlayerBudget() > landedOn.getRent()) {
                    player1.setPlayerBudget(player1.getPlayerBudget() - landedOn.getRent());
                } else {
                    player1.setPlayerBudget(0);
                }
            } else if (landedOn.isDrawsCard()) {
                app.showWarningDialog(landedOn.getSpaceName(), "You have landed on: %s, which will draw you a card.".formatted(landedOn.getSpaceName()));
                //TODO: app.showcard()
            } else {
                app.showWarningDialog(landedOn.getSpaceName(), "You have landed on: %s".formatted(landedOn.getSpaceName()));
            }
            updateProperties();
            //TODO: update gamestate here
        }

    }


    /*
     * This method is meant to set the theme to classic Monopoly and make it possible for later sprints
     * to set up a theme-choose when you launch the game.
     */

    /**
     * @author Madison May
     * @return an array of Space objects, every Space in
     * @throws FileNotFoundException if it can't find spaces.java in the resources folder
     */
    private Space[] loadSpaces() throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(spaceLocation);
        return gson.fromJson(reader, Space[].class);
    }
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
        protected Space getSpace(){
        for(Space space : spaceArray) {
            if(space.getLocation().y == getPlayer1Position().y && space.getLocation().x == getPlayer1Position().x) {
                return space;
            }
        }
        return new Space("AAAH", 0, 0, false, 0, 0);
    }

    protected int getIndexOfSpace(Space spaceToNDX){
        int loc = 0;
        for(Space space : spaceArray) {
            if(Objects.equals(space.getSpaceName(), spaceToNDX.getSpaceName())) {
                return loc;
            }
            loc ++;
        }
        return -1;
    }
    public void buyProperty(Space space) {
        if(player1.getPlayerBudget() > space.getPrice() && !space.isOwned()) {
            space.setCanBePurchased(false);
            space.setOwned(true);
            space.setOwner(player1);
            player1.addProperty(space);
            spaceArray[getIndexOfSpace(space)] = space;
            player1.setPlayerBudget(player1.getPlayerBudget() - space.getRent());
        } else {
            app.showWarningDialog("Nope!", "You cannot buy this property!");
        }
    }
    protected Point getPlayer1Position() {
        int row = GridPane.getRowIndex(p1Piece);
        int column = GridPane.getColumnIndex(p1Piece);
        return new Point(column, row);
    }


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


}
