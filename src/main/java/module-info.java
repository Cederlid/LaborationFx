module com.example.laborationfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laborationfx to javafx.fxml;
    exports com.example.laborationfx;
    exports com.example.laborationfx.controller;
    opens com.example.laborationfx.controller to javafx.fxml;
}