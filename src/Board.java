import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
//test
public class Board {

    public void start(Stage primaryStage) {
        // Create the root layout: GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        // Set the size of each cell in the grid
        int cellSize = 30;

        // Create a 12x12 grid of rectangles (or squares)
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                // Create a rectangle for each cell
                Rectangle rect = new Rectangle(cellSize, cellSize);
                if (i<=2 && j<=2) {
                    rect.setFill(Color.LAVENDER);
                } else if (i>=10 && j<=2) {
                    rect.setFill(Color.LIGHTBLUE);
                } else if (i<=2 && j>=10) {
                    rect.setFill(Color.LIGHTGREEN);
                } else if (i>=10 && j>=10) {
                    rect.setFill(Color.LIGHTCORAL);
                } else if ((i+j)%2 == 0) {
                    rect.setFill(Color.LIGHTGRAY);
                } else {
                    rect.setFill(Color.WHITE);
                }

                // Add the rectangle to the grid
                grid.add(rect, i, j);
            }
        }

        // Create a Scene with the GridPane
        Scene scene = new Scene(grid, 400, 400);

        // Set the stage properties
        primaryStage.setTitle("13x13 Box");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
