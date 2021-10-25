package Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameBoard extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(GameBoard.class.getResource("GameBoard.fxml"));
        Scene scene = new Scene(loader.load(), 1000, 1000);
        primaryStage.setTitle("Monopoly!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {launch();}
}
