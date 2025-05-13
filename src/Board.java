import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the grid for the board
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        int cellSize = 30;

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                Rectangle rect = new Rectangle(cellSize, cellSize);
                if (i <= 2 && j <= 2) {
                    rect.setFill(Color.LAVENDER);
                } else if (i >= 10 && j <= 2) {
                    rect.setFill(Color.LIGHTBLUE);
                } else if (j >= 5 && j <= 7 && i <= 2) {
                    rect.setFill(Color.LAVENDERBLUSH);
                } else if (j >= 5 && j <= 7 && i >= 10) {
                    rect.setFill(Color.ALICEBLUE);
                } else if (i <= 2 && j >= 10) {
                    rect.setFill(Color.LIGHTGREEN);
                } else if (i >= 10 && j >= 10) {
                    rect.setFill(Color.LIGHTCORAL);
                } else if ((i + j) % 2 == 0) {
                    rect.setFill(Color.LIGHTGRAY);
                } else {
                    rect.setFill(Color.WHITE);
                }

                grid.add(rect, i, j);
            }
        }

        TextField inputField = new TextField();
        inputField.setPromptText("Type guess in here");

        inputField.setOnAction(e -> {
            String input = inputField.getText();
            System.out.println("User input: " + input);
            inputField.clear();
        });

        VBox root = new VBox(10, grid, inputField);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 500);

        primaryStage.setTitle("13x13 Board with Input");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
