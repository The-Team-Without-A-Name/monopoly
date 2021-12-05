package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import library.Space;

import java.io.IOException;

public class MonopolyClient extends Application {

    public static void main(String[] args) {

        launch(args);
    }
    public static final String CONNECTION_BOX_FXML = "connectionBox.fxml";
    public static final String GAMEBOARD_FXML = "GameBoard.fxml";
    public static final String GENERIC_MESSAGE_FXML = "genericMessage.fxml";
    public static final String SPACE_MENU_FXML = "spaceMenu.fxml";


    Stage mainStage;
    Stage secondaryStage;
    GameBoardController controller;
    GenericMessageController messageController;
    SpaceMenuController spaceMenuController;

    @Override
    public void start(Stage stage) throws Exception {
       // IconFontFX.register(FontAwesome.getIconFont());

        this.mainStage = stage;
        secondaryStage = new Stage();
        stage.setTitle("Monopoly");
        secondaryStage.setTitle("Property Menu");

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
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 1000);
        controller.InitializeGame();


        mainStage.setScene(scene);


       // controller.initState();
    }

    public boolean showMessage(String title, String message) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        messageController = new GenericMessageController(controller,this, title, message);
        loader.setController(messageController);
        loader.setLocation(getClass().getResource(GENERIC_MESSAGE_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 500, 200);
        messageController.setUpWindow();

        secondaryStage.setScene(scene);
        secondaryStage.showAndWait();

        return messageController.getResult();

    }

    public void showSpace(Space space) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        spaceMenuController = new SpaceMenuController();
        loader.setController(spaceMenuController);
        loader.setLocation(getClass().getResource(SPACE_MENU_FXML));
        Parent root = loader.load();
        Scene scene = new Scene(root, 500, 300);

        mainStage.setScene(scene);
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
