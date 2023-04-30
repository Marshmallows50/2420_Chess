package Chess;

public class MovementManager {

    public TileSymbolGraph grid;
    public Tile[] keys;
    public MovementManager(TileSymbolGraph grid) {
        this.grid = grid;
        this.keys = grid.getKeys();
    }

    /**
     * Determines whether Piece at Tile <code>source</code> has a
     * path to Tile <code>dest</code>, taking into account different
     * pieces' movement patterns and obstacles.
     * @param source The Tile the Piece is on.
     * @param dest The Tile the Piece wants to move to.
     * @return true if Piece has a path to dest, and false otherwise.
     */
    public boolean pieceHasPathTo(Tile source, Tile dest) {
        int s = grid.indexOf(source);
        int v = grid.indexOf(dest);
        boolean tiles = false;
        switch (source.getPiece().rank) {
            case PAWN -> tiles = pawnPathTo(s,v);
            case QUEEN -> tiles = queenPathTo(s,v);
            case KING -> tiles = kingPathTo(s,v);
            case ROOK -> tiles = rookPathTo(s,v);
            case BISHOP -> tiles = bishopPathTo(s,v);
            case KNIGHT -> tiles = knightPathTo(s,v);
        }
        return tiles;
    }

    private boolean pawnPathTo(int source, int dest) {
        //TODO: en passant, Pawn Promotion
        int diff = dest - source;
        switch (Math.abs(diff)) {
            case 8 -> {
                boolean color = keys[source].getPiece().getColor() ? diff>0 : diff<0;
                return !keys[source + (diff)].hasPiece() && color;
            }
            case 7, 9 -> {
                boolean color = (diff > 0) == keys[source].getPiece().getColor();
                return keys[source + diff].hasPiece() && color;
            }
            case 16 -> {
                boolean color = keys[source].getPiece().getColor() ? diff>0 : diff<0;
                return !keys[source + (diff)].hasPiece() && !grid.tileOf(source).getPiece().hasMoved && color;
            }
        }
        return false;
    }

    private boolean kingPathTo(int source, int dest) {
        for (int i:grid.graph().adj(source)) {
            if (i == dest && keys[i].hasPiece())
                return keys[source].getPiece().getColor() != keys[dest].getPiece().getColor();
            else if (i == dest) return true;
        }
        return false;
    }

    private boolean queenPathTo(int source, int dest) {
        return (rookPathTo(source, dest) || bishopPathTo(source, dest));
    }

    private boolean rookPathTo(int source, int dest) {
        int diff;
        if(source > dest) diff = source - dest;
        else diff = dest - source;

        switch (Math.abs(diff)) {
            // vertical movement and checking for clear path
            case 8, 16, 24, 32, 40, 48, 56, 64 -> {
                for(int i = 1; i <= diff / 8; i++) {
                    int currTile;
                    if(source > dest) currTile = source - (i * 8);
                    else currTile = source + (i * 8);
                    boolean pieceInPath = keys[currTile].hasPiece();
                    boolean isDest = (currTile == dest);
                    boolean sameColor;
                    if(pieceInPath && isDest) {
                        sameColor = keys[source].getPiece().getColor() != keys[currTile].getPiece().getColor();
                        return sameColor;
                    } else if(pieceInPath) return false;
                }
            }
            // horizontal movement and checking for clear path
            case 1, 2, 3, 4, 5, 6, 7 -> {
                for(int i = 1; i <= diff; i++) {
                    int currTile;
                    if(source > dest) currTile = source - i;
                    else currTile = source + i;
                    boolean pieceInPath = keys[currTile].hasPiece();
                    boolean isDest = (currTile == dest);
                    boolean sameColor;
                    if(pieceInPath && isDest) {
                        sameColor = keys[source].getPiece().getColor() != keys[currTile].getPiece().getColor();
                        return sameColor;
                    } else if(pieceInPath) return false;
                }
            }
            default -> {
                return false;
            }
        }
        return true;
    }

    private boolean bishopPathTo(int source, int dest) {
        int diff;
        if(source > dest) diff = source - dest;
        else diff = dest - source;
        // diagonal top right = 9 * rows
        // diagonal top left = 7 * rows
        // diagonal bottom right = -9 * rows
        // diagonal bottom left = -7 * rows
        switch (Math.abs(diff)) {
            case 7, 14, 21, 28, 35, 42, 49 -> {
                for(int i = 1; i <= diff / 7; i++) {
                    int currTile;
                    if(source > dest) currTile = source - (i * 7);
                    else currTile = source + (i * 7);
                    boolean pieceInPath = keys[currTile].hasPiece();
                    boolean isDest = (currTile == dest);
                    boolean sameColor;
                    if(pieceInPath && isDest) {
                        sameColor = keys[source].getPiece().getColor() != keys[currTile].getPiece().getColor();
                        return sameColor;
                    } else if(pieceInPath) return false;
                    else if (isDest) return true;
                }
            }

            case 9, 18, 27, 36, 45, 54, 53 -> {
                for(int i = 1; i <= diff / 9; i++) {
                    int currTile;
                    if(source > dest) currTile = source - (i * 9);
                    else currTile = source + (i * 9);
                    boolean pieceInPath = keys[currTile].hasPiece();
                    boolean isDest = (currTile == dest);
                    boolean sameColor;
                    if(pieceInPath && isDest) {
                        sameColor = keys[source].getPiece().getColor() != keys[currTile].getPiece().getColor();
                        return sameColor;
                    } else if(pieceInPath) return false;
                    else if (isDest) return true;
                }
            }

            default -> {
                return false;
            }
        }
        return false;
    }

    private boolean knightPathTo(int source, int dest) {
        // top rights, = +16+1, +8+2
        // top lefts = +16-1, +8-2
        //bottom rights, = -16+1, -8+2
        //bottom lefts = -16-1, -8-2
        int diff = dest - source;
        switch (Math.abs(diff)) {
            case 17, 10, 15, 6 -> {
                if (keys[source + diff].hasPiece())
                    return keys[source].getPiece().getColor() != keys[source + diff].getPiece().getColor();
                else return true;
            }
        }
        return false;
    }
}
