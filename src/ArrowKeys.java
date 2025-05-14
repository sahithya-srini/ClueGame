import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class ArrowKeys {

    private Player player;
    private int[][] board;
    private Label infoLabel;
    private GridPane grid;
    private Circle playerToken;

    public ArrowKeys(Player player, int[][] board, Label infoLabel, GridPane grid, Circle playerToken) {
        this.player = player;
        this.board = board;
        this.infoLabel = infoLabel;
        this.grid = grid;
        this.playerToken = playerToken;
    }

    public void enable(Scene scene) {
        player.startTurn();
        infoLabel.setText(player.getName() + " rolled: " + player.getMovesLeft());

        scene.setOnKeyPressed(e -> {
            System.out.println("Key pressed: " + e.getCode());
            boolean moved = false;

            if (player.getMovesLeft() > 0) {
                if (e.getCode() == KeyCode.UP && player.getRow() > 0) {
                    player.moveUp();
                    moved = true;
                } else if (e.getCode() == KeyCode.DOWN && player.getRow() < board.length - 1) {
                    player.moveDown();
                    moved = true;
                } else if (e.getCode() == KeyCode.LEFT && player.getCol() > 0) {
                    player.moveLeft();
                    moved = true;
                } else if (e.getCode() == KeyCode.RIGHT && player.getCol() < board[0].length - 1) {
                    player.moveRight();
                    moved = true;
                } else if (!isArrowKey(e.getCode())) {
                    infoLabel.setText("Invalid move.");
                    return;
                }

                if (moved) {
                    player.decrementMoves();
                    GridPane.setColumnIndex(playerToken, player.getCol());
                    GridPane.setRowIndex(playerToken, player.getRow());

                    infoLabel.setText(player.getName() + " moved to (" + player.getRow() + ", " + player.getCol() +
                            "). Moves left: " + player.getMovesLeft());

                    if (player.getMovesLeft() == 0) {
                        infoLabel.setText(player.getName() + "'s turn is over!");
                    }
                }
            }
        });
    }

    private boolean isArrowKey(KeyCode code) {
        return code == KeyCode.UP || code == KeyCode.DOWN || code == KeyCode.LEFT || code == KeyCode.RIGHT;
    }
}
