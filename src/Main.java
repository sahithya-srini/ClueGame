import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        int[][] boardArr = new int[12][12];

        Board board = new Board();
        board.start(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
