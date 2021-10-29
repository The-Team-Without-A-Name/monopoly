package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class MonopolyClient extends Application {

    public static void main(String[] args) {

        launch(args);
    }
    public static final String CONNECTION_BOX_FXML = "connectionBox.fxml";
    public static final String GAMEBOARD_FXML = "GameBoard.fxml";

    Stage mainStage;
    GameBoardController controller;

    @Override
    public void start(Stage stage) throws Exception {
       // IconFontFX.register(FontAwesome.getIconFont());

        this.mainStage = stage;
        stage.setTitle("Monopoly");

        showConnect();

        stage.show();
    }



    public void showConnect() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new LoginConnectionForm(this));
        loader.setLocation(getClass().getResource(CONNECTION_BOX_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 400, 325);
        mainStage.setScene(scene);
    }

    public void showBoard() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        controller = new GameBoardController(this);
        loader.setController(controller);
        loader.setLocation(getClass().getResource(GAMEBOARD_FXML));
        Parent root = loader.load(); //this is where it is failing
        Scene scene = new Scene(root, 1000, 1000);
        mainStage.setScene(scene);


       // controller.initState();
    }

    public void showWarningDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }





    /**
    *@Override
    *public void start(Stage gameStage) throws Exception {

     *   gameStage.setTitle("Connection Box");

      *  //Create Grid Pane with padding and alignment
      *  GridPane box=new GridPane();
       * box.setAlignment(Pos.CENTER);
        *box.setHgap(10);
        *box.setVgap(10);
        *box.setPadding(new Insets(25, 25, 25, 25));

        //Add Title to window showing purpose with font, sizing, and alignment
        *Text scenetitle = new Text("Connect To Game");
        *scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        *box.add(scenetitle, 0, 0, 2, 1);

        //Create Labels and add them to box
        *Label userName = new Label("Address:");
        *box.add(userName, 0, 1);
        *Label portVal = new Label("Port Value:");
        *box.add(portVal, 0, 2);

        //Create TextFields and add them to box
        *TextField address=new TextField();
        *box.add(address, 1, 1);
        *TextField port_value=new TextField();
        *box.add(port_value, 1, 2);

        //Create connect button, add padding, and set alignment
        *Button connect=new Button("Connect");
        *HBox hbBtn = new HBox(10);
        *hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        *hbBtn.getChildren().add(connect);
        *box.add(hbBtn, 1, 4);

        //Set scene
        *Scene scene=new Scene(box,300,275);
        *gameStage.setScene(scene);
        *gameStage.show();

        *String str_ad=address.toString();
        *String str_port=address.toString();

        //Connection connection=new Connection();
        //connection.initialize(str_ad,str_port);

       // if (connection.isInitialize()){
       //     System.out.println("Successful in connecting to the server");
        //}
    }
*/
}
