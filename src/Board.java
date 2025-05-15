import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Board extends Application {

    @Override
    public void start(Stage primaryStage) {

        int[][] boardArr = new int[13][13];
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        int cellSize = 30;

        boardLayout(grid, cellSize);


        Label infoLabel = new Label();
        Scene scene = new Scene(grid, 450, 500);

        Circle userToken = new Circle(cellSize / 2.5, Color.BLACK);
        Player user = new Player(2, 2, "user");
        grid.add(userToken, user.getCol(), user.getRow());
        ArrowKeys keysU = new ArrowKeys(user, boardArr, infoLabel, grid, userToken);
        keysU.enable(scene);

        Circle player1Token = new Circle(cellSize / 2.5, Color.BLUE);
        Player player1 = new Player(2, 10, "Player 1");
        grid.add(player1Token, player1.getCol(), player1.getRow());
        ArrowKeys keys1 = new ArrowKeys(player1, boardArr, infoLabel, grid, player1Token);
        keys1.enable(scene);

        Circle player2Token = new Circle(cellSize / 2.5, Color.DARKRED);
        Player player2 = new Player(10, 10, "Player 2");
        grid.add(player2Token, player2.getCol(), player2.getRow());
        ArrowKeys keys2 = new ArrowKeys(player2, boardArr, infoLabel, grid, player2Token);
        keys2.enable(scene);

        Circle player3Token = new Circle(cellSize / 2.5, Color.GREEN);
        Player player3 = new Player(10, 2, "Player 3");
        grid.add(player3Token, player3.getCol(), player3.getRow());
        ArrowKeys keys3 = new ArrowKeys(player3, boardArr, infoLabel, grid, player3Token);
        keys3.enable(scene);


        TextField inputField = new TextField();
        inputField.setPromptText("Type guess in here");

        inputField.setOnAction(e -> {
            String input = inputField.getText();
            System.out.println("User input: " + input);
            inputField.clear();
        });

        VBox root = new VBox(10, grid, inputField);
        root.setAlignment(Pos.CENTER);

        primaryStage.setTitle("13x13 Board with Input");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void boardLayout(GridPane grid, int cellSize) {
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
    }


}
