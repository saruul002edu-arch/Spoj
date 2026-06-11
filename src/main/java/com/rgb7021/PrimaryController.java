package com.rgb7021;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField aInput;
    @FXML private TextField bInput;
    @FXML private TextField cInput;
    @FXML private Label resultLabel;

    @FXML
    private void handleCalculate() {
        try {
            int a = Integer.parseInt(aInput.getText());
            int b = Integer.parseInt(bInput.getText());
            int c = Integer.parseInt(cInput.getText());
            int result = 4 * (a + b + c);
            resultLabel.setText("12 ирмэг = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Тоо оруулна уу!");
        }
    }
}