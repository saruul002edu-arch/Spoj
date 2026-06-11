package com.rgb7020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PrimaryController {
    @FXML private GridPane boardGrid;
    @FXML private TextField mInput;
    @FXML private TextField nInput;
    @FXML private Label resultLabel;
    @FXML private Button solveButton;
    @FXML private Button clearButton;

    private int M = 2, N = 4;
    private int[][] grid;

    private static final String[] COLORS = {
        "#F4C0D1", "#B5D4F4", "#C0DD97", "#FAC775",
        "#CECBF6", "#9FE1CB", "#F5C4B3", "#D3D1C7"
    };

    @FXML
    public void initialize() {
        drawBoard(M, N);
    }

    @FXML
    private void handleSolve() {
        try {
            M = Math.max(1, Math.min(16, Integer.parseInt(mInput.getText())));
            N = Math.max(1, Math.min(16, Integer.parseInt(nInput.getText())));
        } catch (NumberFormatException e) {
            resultLabel.setText("⚠ Зөв тоо оруулна уу");
            return;
        }

        grid = new int[M][N];
        for (int[] row : grid) Arrays.fill(row, -1);

        int dominoId = 0;
        List<int[][]> dominoes = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == -1) {
                    if (j + 1 < N && grid[i][j + 1] == -1) {
                        grid[i][j] = dominoId;
                        grid[i][j + 1] = dominoId;
                        dominoes.add(new int[][]{{i, j}, {i, j + 1}});
                        dominoId++;
                    } else if (i + 1 < M && grid[i + 1][j] == -1) {
                        grid[i][j] = dominoId;
                        grid[i + 1][j] = dominoId;
                        dominoes.add(new int[][]{{i, j}, {i + 1, j}});
                        dominoId++;
                    }
                }
            }
        }

        drawSolution(dominoes);
        resultLabel.setText("🀱 " + dominoes.size() + " домино");
    }

    @FXML
    private void handleClear() {
        try {
            M = Math.max(1, Math.min(16, Integer.parseInt(mInput.getText())));
            N = Math.max(1, Math.min(16, Integer.parseInt(nInput.getText())));
        } catch (NumberFormatException ignored) {}
        drawBoard(M, N);
        resultLabel.setText("");
    }

    private void drawBoard(int m, int n) {
        boardGrid.getChildren().clear();
        boardGrid.getRowConstraints().clear();
        boardGrid.getColumnConstraints().clear();

        for (int i = 0; i < m; i++) {
            boardGrid.getRowConstraints().add(new RowConstraints(50));
            for (int j = 0; j < n; j++) {
                if (i == 0) boardGrid.getColumnConstraints().add(new ColumnConstraints(50));
                Rectangle cell = new Rectangle(44, 44);
                cell.setFill(Color.web("#F1EFE8"));
                cell.setStroke(Color.web("#D3D1C7"));
                cell.setStrokeWidth(0.5);
                cell.setArcWidth(10);
                cell.setArcHeight(10);
                boardGrid.add(cell, j, i);
            }
        }
    }

    private void drawSolution(List<int[][]> dominoes) {
        boardGrid.getChildren().clear();
        boardGrid.getRowConstraints().clear();
        boardGrid.getColumnConstraints().clear();

        for (int i = 0; i < M; i++) boardGrid.getRowConstraints().add(new RowConstraints(50));
        for (int j = 0; j < N; j++) boardGrid.getColumnConstraints().add(new ColumnConstraints(50));

        boolean[][] placed = new boolean[M][N];

        for (int d = 0; d < dominoes.size(); d++) {
            int[][] cells = dominoes.get(d);
            String color = COLORS[d % COLORS.length];
            boolean horizontal = cells[0][0] == cells[1][0];

            for (int[] cell : cells) {
                int row = cell[0], col = cell[1];
                placed[row][col] = true;
                Rectangle rect = new Rectangle(44, 44);
                rect.setFill(Color.web(color));
                rect.setStroke(Color.web("#C0C0B8"));
                rect.setStrokeWidth(0.5);
                rect.setArcWidth(10);
                rect.setArcHeight(10);
                Label lbl = new Label(horizontal ? "↔" : "↕");
                lbl.setStyle("-fx-font-size: 13px; -fx-text-fill: #555;");
                StackPane stack = new StackPane(rect, lbl);
                boardGrid.add(stack, col, row);
            }
        }

        // Хоосон нүднүүд
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!placed[i][j]) {
                    Rectangle cell = new Rectangle(44, 44);
                    cell.setFill(Color.web("#F1EFE8"));
                    cell.setStroke(Color.web("#D3D1C7"));
                    cell.setStrokeWidth(0.5);
                    cell.setArcWidth(10);
                    cell.setArcHeight(10);
                    boardGrid.add(cell, j, i);
                }
            }
        }
    }
}