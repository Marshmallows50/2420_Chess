package Chess;

import java.awt.*;

public class Tile implements Comparable<Tile> {

    private String name;
    public Piece piece;
    private Color color;

    private int x;
    private int y;

    public Tile(String name, int x, int y, String color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.piece = null;
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

    public void setPiece(Piece piece) {
        if (piece == null){
            this.piece= null;
            return;
        }
        this.piece = piece;
        this.piece.cords = this;
    }

    public Color getColor() {
        return color;
    }

    public void movePieceTo(Tile newTile) {
        piece.hasMoved = true;
        newTile.setPiece(piece);
        piece = null;
    }

    public Iterable<Piece> getAdjacentPieces() {
        return null; //TODO
    }

    @Override
    public int compareTo(Tile other) {
        if (this.y != other.y)
            return Integer.compare(this.y, other.y);
        else return Integer.compare(this.x, other.x);
    }

    @Override
    public String toString() {
        return name;
    }
}
