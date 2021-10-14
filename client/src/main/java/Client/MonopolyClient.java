package Client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MonopolyClient extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage gameStage) throws Exception {

        gameStage.setTitle("Connection Box");
        GridPane box=new GridPane();
        TextField address=new TextField();
        TextField port_value=new TextField();
        Button connect=new Button("Connect");
        box.add(connect,4,4);
        box.add(port_value,5,2);
        box.add(address,2,2);
        Scene scene=new Scene(box,500,100);
        gameStage.setScene(scene);
        gameStage.show();

        String str_ad=address.toString();
        String str_port=address.toString();

        Connection connection=new Connection();
        connection.initialize(str_ad,str_port);

        if (connection.isInitialize()){
            System.out.println("Successful in connecting to the server");
        }
    }

}
