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


    public LoginConnectionForm(MonopolyClient app){
        this.app = app;
    }

    //Textfield URI and Spinner For address and Port.
    //
    //


    //BUTTON ACTION
    protected void handleLoginPress(ActionEvent event){
        ADD IF STATEMENT THAT CHECKS URI AND SPINNER AFTER INITIAL GUI IS REIMPLEMENTED.
        if(uri.getText().isBlank()){
           app.showDialog("PORT AND ADDRESS MISSING");
            return;
        }

        //CALL connection.init and connection.instance to ensure proper connection.
    }

}
