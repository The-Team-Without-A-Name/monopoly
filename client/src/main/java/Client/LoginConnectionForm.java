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
<<<<<<< HEAD:client/src/main/java/LoginConnectionForm.java
//    protected void handleLoginPress(ActionEvent event){
//        //ADD IF STATEMENT THAT CHECKS URI AND SPINNER AFTER INITIAL GUI IS REIMPLEMENTED.
//        if(uri.getText().isBlank()){
//            app.showDialog("PORT AND ADDRESS MISSING");
//            return;
//        }
=======
    protected void handleLoginPress(ActionEvent event){
       // ADD IF STATEMENT THAT CHECKS URI AND SPINNER AFTER INITIAL GUI IS REIMPLEMENTED.
        if(uri.getText().isBlank()){
           app.showDialog("PORT AND ADDRESS MISSING");
            return;
        }
>>>>>>> 2cbc8a357aa14b7b2c80a2facc7a936b005bebd5:client/src/main/java/Client/LoginConnectionForm.java

        //CALL connection.init and connection.instance to ensure proper connection.
//    }

}
