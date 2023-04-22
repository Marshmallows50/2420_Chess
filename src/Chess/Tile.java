package Chess;

public class Tile implements Comparable<Tile> {

    private String name;
    private Piece piece;
    private String color;


    private int x;
    private int y;

    public Tile(String name, int x, int y, String color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = color;
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
        this.piece = piece;
        piece.cords = this;
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

    public String getColor() {
        return color;
    }
}
