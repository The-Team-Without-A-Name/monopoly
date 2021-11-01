package Client;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;

/**
 * GameBoardController contains FXML objects, buttons, and methods.
 * Sets up how the player moves along with the dice roll.
 */

public class GameBoardController {

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
    private ChoiceBox choiceBox;




    public GameBoardController(MonopolyClient app) { this.app = app;}
    //FXML button methods
    @FXML
    protected void onStartButtonClick() throws FileNotFoundException {

        if (!gameBoard.getChildren().contains(piece)) {
            gameBoard.add(piece, 10, 0);
            gameBoard.setHalignment(piece, HPos.CENTER);
            gameBoard.setValignment(piece, VPos.CENTER);
        }
    }
    @FXML
    protected void onMoveButtonClick() {
        //move for some input from server
        Move(4);
    }

    protected void Move(int movement) {
        if (gameBoard.getChildren().contains(piece)) {
        for(int i = 0; i < movement; i++) {
                int column = gameBoard.getColumnIndex(piece);
                int row = gameBoard.getRowIndex(piece);

                if (onTopRow(column, row)) gameBoard.setColumnIndex(piece, column + 1);
                if (onBottomRow(column, row)) gameBoard.setColumnIndex(piece, column - 1);
                if (onRightColumn(column, row)) gameBoard.setRowIndex(piece, row + 1);
                if (onLeftColumn(column, row)) gameBoard.setRowIndex(piece, row - 1);
                gameBoard.setHalignment(piece, HPos.CENTER);
                gameBoard.setValignment(piece, VPos.CENTER);

            }
        }
    }

    @FXML
    protected void onDiceButtonClick() {
        //Need to send dice roll request to server
        dice.setText("Dice rolled");
    }

    //Regular internal methods

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
