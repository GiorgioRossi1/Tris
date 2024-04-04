package it.edu.iisgubbio.giocoFinale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterfacciaGioco extends Application {

    private Button[][] buttons = new Button[3][3];
    private boolean isPlayerX = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                button.setOnAction(e -> {
                    if (button.getText().isEmpty()) {
                        button.setText(isPlayerX ? "X" : "O");
                        isPlayerX = !isPlayerX;
                    }
                });
                buttons[i][j] = button;
                gridPane.add(button, i, j);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tris Game");
        primaryStage.show();
    }
}