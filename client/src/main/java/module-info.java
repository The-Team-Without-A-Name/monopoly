module Client {
    requires javafx.controls;
    requires java.net.http;
    requires javafx.fxml;
    requires javafx.base;
    requires library;
    exports Client;
    opens Client to javafx.fxml;


}