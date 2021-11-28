package Client;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Madison May
 * Just a FXML controller for basic pop-up messages and the skeleton for card pop-ups
 */

public class GenericMessageController {

    public GenericMessageController(MonopolyClient app) {this.app = app;}

    private MonopolyClient app;

    public String title;


    public String message;

    @FXML
    public DialogPane dialogPane;

    public void generateMessageWindow() {
        dialogPane.setHeaderText(title);
        dialogPane.setContentText(message);
    }

}
