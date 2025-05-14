import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        ArrayList<String> roomList = new ArrayList<>();
        roomList.add("Room 1");
        roomList.add("Room 2");
        roomList.add("Room 3");
        roomList.add("Room 4");
        roomList.add("Room 5");
        roomList.add("Room 6");
        String roomKilled = roomList.remove((int)(Math.random() * 6));

        ArrayList<String> suspectList = new ArrayList<>();
        suspectList.add("Suspect 1");
        suspectList.add("Suspect 2");
        suspectList.add("Suspect 3");
        suspectList.add("Suspect 4");
        String killer = suspectList.remove((int)(Math.random() * 4));

        System.out.println(("Killer : " + killer + "\nRoom Killed: " + roomKilled));



        int[][] boardArr = new int[12][12];
        Board board = new Board();
        board.start(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
