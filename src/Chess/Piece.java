package Chess;

import javax.swing.*;

public abstract class Piece {

    // Fields
    private Boolean color;
    private String rank;
    private ImageIcon icon;
    private Tile cords; //TODO we need a node class

    public Piece(boolean color, String rank, ImageIcon icon) {
        // children will call this super().
        this.color = color;
        this.rank = rank;
        this.icon = icon;
    }

    public Boolean getColor() {
        return color;
    }

    public String getRank() {
        return rank;
    }

    public void kill() {
        System.out.println("It will myyyyyyyurderrrrrrrr");
    }

    // I think this should return a boolean?
    public boolean validateMovement() {
        return false; //TODO
    }


}