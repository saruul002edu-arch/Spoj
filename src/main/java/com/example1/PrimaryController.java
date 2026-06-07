package com.example1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField inputField;

    @FXML
    private TextField outputField;

    @FXML
    public void initialize() {
        inputField.textProperty().addListener((obs, oldVal, newVal) -> {
            outputField.setText(newVal.toLowerCase());
        });
    }

}
