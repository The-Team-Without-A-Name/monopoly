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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
    private Label dice;

    @FXML
    private GridPane gameBoard;

    @FXML
    private Rectangle piece;

    @FXML
    private VBox buttonBox;

    @FXML
    private ChoiceBox themeBox;

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




    public GameBoardController(MonopolyClient app) throws FileNotFoundException { this.app = app;}

    //FXML button methods
    @FXML
    protected void onStartButtonClick() throws FileNotFoundException {

        if (!gameBoard.getChildren().contains(piece)) {
            gameBoard.add(piece, 10, 10);
            gameBoard.setHalignment(piece, HPos.CENTER);
            gameBoard.setValignment(piece, VPos.CENTER);
        }
        setTheme(resource + basicThemeLocation);
    }
    @FXML
    protected void onMoveButtonClick() {
        //move for some input from server
        Move(4);
    }


    @FXML
    protected void onDiceButtonClick() {
        //Need to send dice roll request to server
        dice.setText("Dice rolled");
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
        CommunityChest2.setFill(getImageFill(themeFolder + "CommunityChest.png"));
        TenAve.setFill(getImageFill(themeFolder + "TennesseeAvenue.png"));
        NewAve.setFill(getImageFill(themeFolder + "NewYorkAvenue.png"));
        FreeParking.setFill(getImageFill(themeFolder + "FreeParking.png"));
        KenAve.setFill(getImageFill(themeFolder + "KentuckyAvenue.png"));
        Chance2.setFill((getImageFill(themeFolder + "Chance.png")));
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
        CommunityChest3.setFill(getImageFill(themeFolder + "CommunityChest.png"));
        PenAve.setFill(getImageFill(themeFolder + "PennsylvaniaAvenue.png"));
        ShortLine.setFill(getImageFill(themeFolder + "ShortLine.png"));
        Chance3.setFill(getImageFill(themeFolder + "Chance.png"));
        ParPla.setFill(getImageFill(themeFolder + "ParkPlace.png"));
        LuxuryTax.setFill(getImageFill(themeFolder + "LuxuryTax.png"));
        BoardWalk.setFill(getImageFill(themeFolder + "Boardwalk.png"));


    }

    //Regular internal methods
    protected ImagePattern getImageFill(String image) throws FileNotFoundException {
        return new ImagePattern(new Image(new FileInputStream(image)));
    }
    protected void Move(int movement) {
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
