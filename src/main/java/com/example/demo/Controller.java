package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
public class Controller {
    int w=0;
    @FXML
    private TextField rowsField;

    @FXML
    private TextField colsField;
    @FXML
    private GridPane gridPane;
    private Map map;

    @FXML
    private void handleAddObstacle() {
        if (map == null) {
            showError("Please set the map dimensions first.");
            return;
        }

        // Example: Add an obstacle at a hardcoded position
        w=1;
        System.out.println("You are now adding obstacles.");

    }

    @FXML
    private void handleAddChargingPoint() {
        if (map == null) {
            showError("Please set the map dimensions first.");
            return;
        }

       w=2;
        System.out.println("You are now adding CharginPoints.");
    }

    @FXML
    private void handleStartSimulation() {
        if (map == null) {
            showError("Please set the map dimensions first.");
            return;
        }

        // Example: Initialize the simulation (you can enhance this part)
        System.out.println("Simulation started!");

        map.afficher(); // Show the map
    }

    @FXML
    private void initialize() {
        // Initialize anything needed here
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void handleCellClick(int x, int y) {
        if (w==0) {
            System.out.println("Please select an action first (Obstacle or Charging Point).");
            return; // Exit if no action is selected
        }

        if (map == null) {
            System.out.println("Map is not initialized.");
            return;
        }

        // Add obstacle or charging point based on the current action
        if (w==1) {
            addObstacle(x, y);
        } else if (w==2) {
            addChargingPoint(x, y);
        }
    }

    private void addObstacle(int x, int y) {
        Obstacle obstacle = new Obstacle(new Point(x, y));
        map.addObstacle(obstacle);
        System.out.println("Obstacle added at (" + x + ", " + y + ")");
        updateCellButton(x, y);
    }
    private void addChargingPoint(int x, int y) {
        ChargingPoint chargingPoint = new ChargingPoint(new Point(x, y));
        map.addCharginPoint(new Point(x, y));
        System.out.println("Charging point added at (" + x + ", " + y + ")");
        updateCellButton(x, y);
    }
    // Updates the button style based on whether it's an obstacle or charging poin
    private void updateCellButton(int x, int y) {
        Button button = getButtonFromGrid(x, y); // Retrieve the button at (x, y)
        if (button != null) {
            if (w==1) {
                button.setStyle("-fx-background-color: red;"); // Set style for obstacle
            } else if (w==2) {
                button.setStyle("-fx-background-color: green;"); // Set style for charging points
            }
        }
    }
    private Button getButtonFromGrid(int x, int y) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == x && GridPane.getColumnIndex(node) == y) {
                return (Button) node;
            }
        }
        return null;
    }

    @FXML
    private void createGrid(int rows, int cols) {
        gridPane.getChildren().clear(); // Clear any previous grid

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Button cellButton = new Button();
                cellButton.setMinSize(15, 15); // Set button size for each cell
                cellButton.setStyle("-fx-background-color: lightgray; -fx-text-fill: black; -fx-font-size: 12; -fx-font-weight: bold;");

                // Optional: make the button have rounded corners like the Add Obstacle button
                cellButton.setShape(new javafx.scene.shape.Rectangle(20, 20)); // Rounded corners with radius 20
                cellButton.setStyle("-fx-background-color: lightgray; -fx-text-fill: black; -fx-font-size: 12; -fx-font-weight: bold; -fx-background-radius: 15;");


                // Action when the cell button is clicked
                int finalI = i;
                int finalJ = j;
                cellButton.setOnAction(event -> handleCellClick(finalI, finalJ));

                // Add the button to the grid at the correct position
                gridPane.add(cellButton, j, i);}
    }}
    @FXML
    private void handleSetMapDimensions() {
        try {
            int rows = Integer.parseInt(rowsField.getText());
            int cols = Integer.parseInt(colsField.getText());
            map = new Map(rows, cols);
            System.out.println("Map created with dimensions: " + rows + "x" + cols);
            createGrid(rows, cols);
        } catch (NumberFormatException e) {
            showError("Please enter valid integers for rows and columns.");
        }
    }


}
