import java.util.ArrayList;

public class Player {

    private int row;
    private int col;
    private String name;
    private int movesLeft;

    private String[] hand = new String[2];

    public Player(int row, int col, String name) {
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public void startTurn() {
        movesLeft = roll();
        System.out.println(name + " rolled: " + movesLeft);
    }

    public int roll() {
        System.out.println("Rolling 2 dice");
        int n = (int)(Math.random() * 6) + 1;
        n += (int)(Math.random() * 6) + 1;
        return n;
    }

    // Movement helpers
    public void moveUp() { row--; }
    public void moveDown() { row++; }
    public void moveLeft() { col--; }
    public void moveRight() { col++; }
    public void decrementMoves() { movesLeft--; }

    // Getters
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getMovesLeft() { return movesLeft; }
    public String getName() {
        return name;
    }
}
