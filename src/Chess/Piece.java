package Chess;

import Chess.Pieces.Rank;

import java.awt.*;

public class Piece {

    // Fields
    private final boolean color;
    public Rank rank;
    public Image image;
    public Tile cords;
    public boolean hasMoved;

    public Piece(boolean color) {
        this.color = color;
        hasMoved = false;
    }

    /**
     * Returns the Piece color as a boolean where true = white
     * and false = black.
     * @return true if Piece is white and false otherwise.
     */
    public boolean getColor() {
        return color;
    }

}