package Client;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import library.Space;

import java.awt.*;

/**
 * @author Madison May
 * Space Menu for whatever space the player may land on.
 */

public class SpaceMenuController extends Application {

    private Space space;
    private MonopolyClient app;

    @FXML
    Label spaceName;

    @FXML
    Button purchaseProperty;


    @Override
    public void start(Stage primaryStage) {

    }
}
