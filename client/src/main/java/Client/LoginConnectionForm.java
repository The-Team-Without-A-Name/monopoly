package Client;

import Client.MonopolyClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class LoginConnectionForm {


    private MonopolyClient app;

    @FXML
    TextField uri;
    @FXML
    Spinner <Integer> port;

    public LoginConnectionForm(MonopolyClient app){
        this.app = app;
    }



    //BUTTON ACTION
    @FXML
  protected void handleLoginPress(ActionEvent event){
        //ADD IF STATEMENT THAT CHECKS URI AND SPINNER AFTER INITIAL GUI IS REIMPLEMENTED.
      if (uri.getText().isBlank()) {
          app.showWarningDialog("Address Missing", "Server address cannot be blank");
          return;
      }

      Connection connection = Connection.instance();
      connection.initialize(uri.getText(), port.getValue().toString());

      if (connection.initialized && connection.test()) {
          try {
              app.showBoard();
          } catch (IOException ex) {
              //app.showExceptionDialog("Cant load game board, try restarting the program", ex);
          }
      } else {
          app.showWarningDialog("Error Connecting", "Couldn't connect to the server. Make sure that port and address are correct and try again.");
      }
  }


}
//&& connection.test()