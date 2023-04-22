package Chess;

public class Tile {
    private Boolean hasPiece;
    private Piece piece;
    private int row;
    private int column;

    public Tile() {

    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public Boolean getHasPiece() {
        return hasPiece;
    }

    public void setHasPiece(Boolean hasPiece) {
        this.hasPiece = hasPiece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Iterable<Piece> getAdjacentPieces() {
        return null; //TODO
    }
}
