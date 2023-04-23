package Chess;

import java.awt.*;

public class Tile implements Comparable<Tile> {

    private String name;
    private Piece piece;
    private Color color;


    private int x;
    private int y;

    public Tile(String name, int x, int y, String color) {
        this.name = name;
        this.x = x;
        this.y = y;
        if(color.equals("B"))
            this.color = Color.BLACK;
        else
            this.color = Color.WHITE;
    }

    public String getName() {
        return name;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Boolean hasPiece() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece oldPiece) {
        Piece newPiece = new Piece(oldPiece);
        this.piece = newPiece;
        piece.hasMoved = true;
        piece.cords = this;
    }

    public void movePiece(Tile newTile) {
        newTile.setPiece(piece);
        piece = null;
    }

    public Iterable<Piece> getAdjacentPieces() {
        return null; //TODO
    }

    @Override
    public int compareTo(Tile other) {
        if (this.x != other.x)
            return Integer.compare(this.x, other.x);
        else
            return Integer.compare(this.y, other.y);
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name;
    }
}
