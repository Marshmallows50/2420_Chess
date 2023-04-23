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
        // children will call this super().
        this.color = color;
        hasMoved = false;
    }

    public Piece(Piece pieceToCopy) {
        this.color = pieceToCopy.color;
        this.rank = pieceToCopy.rank;
        this.image = pieceToCopy.image;
        this.cords = pieceToCopy.cords;
        this.hasMoved = pieceToCopy.hasMoved;
    }

    public boolean getColor() {
        return color;
    }

    public void kill() {
        System.out.println("It will myyyyyyyurderrrrrrrr");
    }

    // I think this should return a boolean?
    public boolean validateMovement() {
        return false; //TODO
    }

}