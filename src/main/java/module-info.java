module com.rgb7020 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rgb7020 to javafx.fxml;
    exports com.rgb7020;
}
