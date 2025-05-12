import javafx.scene.Scene;

public class ArrowKeys {

    private Player player;
    private int[][] board;

    public ArrowKeys(Player player, int[][] board) {
        this.player = player;
        this.board = board;
    }

    public void enable(Scene scene) {
        player.startTurn();  // Rolls dice and prints moves left

        scene.setOnKeyPressed(e -> {
            System.out.println("Key pressed: " + e.getCode()); // Log key code for debugging
            if (player.getMovesLeft() > 0) {
                switch (e.getCode()) {
                    case UP:
                        if (player.getRow() > 0) player.moveUp();
                        break;
                    case DOWN:
                        if (player.getRow() < board.length - 1) player.moveDown();
                        break;
                    case LEFT:
                        if (player.getCol() > 0) player.moveLeft();
                        break;
                    case RIGHT:
                        if (player.getCol() < board[0].length - 1) player.moveRight();
                        break;
                    default:
                        // Only print invalid move if a non-arrow key is pressed
                        if (!isArrowKey(e.getCode())) {
                            System.out.println("Invalid move");
                        }
                        return;
                }
                player.decrementMoves();
                System.out.println(player.getName() + " moved to: (" + player.getRow() + ", " + player.getCol() + ")");
                System.out.println("Moves left: " + player.getMovesLeft());
                if (player.getMovesLeft() == 0) {
                    System.out.println(player.getName() + "'s turn is over!");
                }
            }
        });
    }

    // Helper function to check if the key is an arrow key
    private boolean isArrowKey(javafx.scene.input.KeyCode code) {
        return code == javafx.scene.input.KeyCode.UP ||
                code == javafx.scene.input.KeyCode.DOWN ||
                code == javafx.scene.input.KeyCode.LEFT ||
                code == javafx.scene.input.KeyCode.RIGHT;
    }
}
