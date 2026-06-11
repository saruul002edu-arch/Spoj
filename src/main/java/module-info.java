module com.example3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example3 to javafx.fxml;
    exports com.example3;
}
