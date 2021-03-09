module com.max1maka {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.max1maka to javafx.fxml;
    exports com.max1maka;
}