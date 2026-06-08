package com.example2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField yearField;

    @FXML
    private TextField monthField;

    @FXML
    private TextField outputField;

    @FXML
    public void initialize() {
        yearField.textProperty().addListener((obs, o, n) -> convert());
        monthField.textProperty().addListener((obs, o, n) -> convert());
    }

    private void convert() {
        try {
            int year = Integer.parseInt(yearField.getText().trim());
            int month = Integer.parseInt(monthField.getText().trim());

            int totalMonths = year * 12 + month;
            outputField.setText(String.valueOf(totalMonths));

        } catch (NumberFormatException e) {
            outputField.setText("");
        }
    }
}
