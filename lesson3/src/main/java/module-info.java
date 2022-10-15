module com.example.javafxchat44 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.example.javafxchat44.client;
    opens com.example.javafxchat44.client to javafx.fxml;
}