module com.rgb7019 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rgb7019 to javafx.fxml;
    exports com.rgb7019;
}
