package Chess;

import java.util.ArrayList;

public class Player {

    private final boolean color;
    public ArrayList<Piece> alive = new ArrayList<>(16);
    public ArrayList<Piece> dead = new ArrayList<>();
    public boolean isInCheck;

    public Piece king;

    public Player(boolean color, Piece king) {
        this.color = color;
        this.king = king;
    }
    /**
     * Returns the Player color as a boolean where true = white
     * and false = black.
     * @return true if Player is white and false otherwise.
     */
    public Boolean getColor() {
        return color;
    }
}
