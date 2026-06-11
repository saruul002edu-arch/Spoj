package com.example3;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField nField;

    @FXML
    private TextField weightsField;

    @FXML
    private TextField outputField;

    @FXML
    private Button solveButton;

    @FXML
    public void onSolve() {
        int n = Integer.parseInt(nField.getText().trim());
        String[] parts = weightsField.getText().trim().split("\\s+");
        
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(parts[i]);
        }

        outputField.setText(String.valueOf(toys(w)));
    }

    private int toys(int[] w) {
        Arrays.sort(w);
        int containers = 1;
        int min = w[0], max = w[0];

        for (int i = 1; i < w.length; i++) {
            max = w[i];
            if (max - min > 4) {
                containers++;
                min = w[i];
            }
        }

        return containers;
    }

}
