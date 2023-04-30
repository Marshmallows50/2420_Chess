package Chess;

import java.awt.*;

public class Tile implements Comparable<Tile> {

    public Piece piece;
    private final String name;
    private final Color color;
    private final int x;
    private final int y;

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

    /**
     * Returns the name value (eg. A1, E4, H7, etc) of this Tile.
     * @return Name of Tile.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the y coordinate (or 'number' value on a chess board)
     * of this Tile.
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Returns the x coordinate (or 'letter' value on a chess board)
     * of this Tile.
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Determines if there is a piece on this Tile.
     * @return true if Tile has a piece and false otherwise.
     */
    public Boolean hasPiece() {
        return piece != null;
    }

    /**
     * Returns the Tile's piece if it has one and
     * null otherwise
     * @return This Tile's piece if it has one and null otherwise
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Sets or replaces this Tile's piece to <code>piece</code>
     * @param piece The new piece to be set.
     */
    public void setPiece(Piece piece) {
        if (piece == null){
            this.piece = null;
            return;
        }
        this.piece = piece;
        this.piece.cords = this;
    }

    /**
     * Returns the Tile color.
     * @return color of Tile
     */
    public Color getColor() {
        return color;
    }

    /**
     * Moves this Tile's piece to Tile <code>newTile</code>
     * @param newTile Tile to move this Tile's piece to.
     */
    public void movePieceTo(Tile newTile) {
        piece.hasMoved = true;
        newTile.setPiece(piece);
        piece = null;
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
