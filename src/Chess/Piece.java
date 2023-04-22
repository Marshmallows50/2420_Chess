package Chess;

import Chess.Pieces.Rank;

import java.awt.*;

public abstract class Piece {

    // Fields
    private boolean color;
    public Rank rank;
    public Image image;
    public Tile cords;

    public Piece(boolean color) {
        // children will call this super().
        this.color = color;
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