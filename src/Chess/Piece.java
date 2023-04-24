package Chess;

import Chess.Pieces.Rank;

import java.awt.*;

public class Piece {

    // Fields
    private boolean color;
    public Rank rank;
    public Image image;
    public Tile cords;
    public boolean hasMoved;

    public Piece(boolean color) {
        this.color = color;
        hasMoved = false;
    }

    public boolean getColor() {
        return color;
    }

}