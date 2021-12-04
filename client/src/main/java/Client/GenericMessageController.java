package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import library.Player;
import library.Space;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Madison May
 * Just a FXML controller for basic pop-up messages and the skeleton for card pop-ups
 */

public class GenericMessageController {

    public GenericMessageController(GameBoardController gameBoardController, MonopolyClient app, String title, String message) {
        this.app = app;
        this.title = title;
        this.message = message;
        this.gameBoardController = gameBoardController;
    }

    private MonopolyClient app;

    private String title;

    private GameBoardController gameBoardController;

    private String message;

    @FXML
    private Label nameOfProperty;

    @FXML
    private Label propertyOwnership;

    @FXML
    private Label price;

    @FXML
    private Label rent;

    @FXML
    private Button buy;

    @FXML
    private Button dontBuy;

    @FXML
    public AnchorPane anchorPane;

    public void setUpWindow() {
        Space space = gameBoardController.getSpace();
        nameOfProperty.setText(space.getSpaceName());
        propertyOwnership.setText("No one");
        if(space.getOwner() != null) {
            propertyOwnership.setText(space.getOwner().getPlayerName());
        }
        price.setText(String.valueOf(space.getPrice()));
        rent.setText(String.valueOf(space.getRent()));
    }

    @FXML
    public boolean handleBuyProperty(){
        gameBoardController.buyProperty(gameBoardController.getSpace());
        Stage stage = (Stage) dontBuy.getScene().getWindow();
        stage.close();
        return true;
    }
    @FXML
    public boolean handleDontBuy() {
        //just close the window
        Stage stage = (Stage) dontBuy.getScene().getWindow();
        stage.close();
        return false;
    }



}
