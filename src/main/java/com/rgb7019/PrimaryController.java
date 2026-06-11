package com.rgb7019;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// RGB7019Controller.java
public class PrimaryController {

    @FXML private TextField bInput;
    @FXML private TextField cInput;
    @FXML private TextField dInput;
    @FXML private Label resultLabel;

    @FXML
    private void handleCalculate() {
        try {
            int b = Integer.parseInt(bInput.getText());
            int c = Integer.parseInt(cInput.getText());
            int d = Integer.parseInt(dInput.getText());
            int a = b * c - d;
            resultLabel.setText("A = " + a);
        } catch (NumberFormatException e) {
            resultLabel.setText("Тоо оруулна уу!");
        }
    }
}