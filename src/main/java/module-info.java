module com.rgb7021 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rgb7021 to javafx.fxml;
    exports com.rgb7021;
}
