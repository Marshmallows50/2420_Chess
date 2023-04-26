package Chess;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;

public class TileBFPsManager {

    public TileSymbolGraph tsg;
    public Tile[] grid;
    public TileBFPsManager(TileSymbolGraph tsg) {
        this.tsg = tsg;
        this.grid = tsg.getKeys();
    }

//    public boolean pieceHasPathTo(Tile source, Tile dest) {
//        Stack<Integer> path = null;
//        if(path == null)
//            return false;
//
//        while (!path.isEmpty()) {
//            Tile tile = tsg.tileOf(path.pop());
////            System.out.println("tile: " + tile);
//            if(!tile.getName().equals(source.getName()) && !tile.getName().equals(dest.getName())) {
//                if (tile.hasPiece())
//                    return false;
//            }
//            else if (tile.hasPiece() && (tile.getPiece().getColor() != source.getPiece().getColor())) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean pieceHasPathTo(Tile source, Tile dest) {
        int s = tsg.indexOf(source);
        int v = tsg.indexOf(dest);
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
        // 1d array math method
        int diff = dest - source;
        if (grid[source].getPiece().getColor())
            switch (diff) {
                case 8 -> {
                    return !grid[source + diff].hasPiece();
                }
                case 7, 9 -> {
                    return grid[source + diff].hasPiece() && !grid[source + diff].getPiece().getColor();
                }
                case 16 -> {
                    return !grid[source + diff].hasPiece() && !tsg.tileOf(source).getPiece().hasMoved;
                }
            }
        else {
            switch (diff) {
                case -8 -> {
                    return !grid[source + diff].hasPiece();
                }
                case -7, -9 -> {
                    return grid[source + diff].hasPiece() && grid[source + diff].getPiece().getColor();
                }
                case -16 -> {
                    return !grid[source + diff].hasPiece() && !tsg.tileOf(source).getPiece().hasMoved;
                }
            }
        }
        return false;
    }

    private boolean kingPathTo(int source, int dest) {
        return false; // TODO: NO
    }

    private boolean queenPathTo(int source, int dest) {
        return (rookPathTo(source, dest) || bishopPathTo(source, dest));
    }

    private boolean rookPathTo(int source, int dest) {
        int diff = 0;
        if(source > dest) diff = source - dest;
        else diff = dest - source;

        switch (Math.abs(diff)) {
            // vertical movement and checking for clear path
            case 8, 16, 24, 32, 40, 48, 56, 64 -> {
                for(int i = 1; i <= diff / 8; i++) {
                    int currTile = 0;
                    if(source > dest) currTile = source - (i * 8);
                    else currTile = source + (i * 8);
                    boolean pieceInPath = grid[currTile].hasPiece();
                    boolean isDest = (currTile == dest);
                    boolean sameColor = false;
                    if(pieceInPath && isDest) {
                        sameColor = grid[source].getPiece().getColor() != grid[currTile].getPiece().getColor();
                        return sameColor;
                    } else if(pieceInPath) return false;
                }
            }
            // horizontal movement and checking for clear path
            case 1, 2, 3, 4, 5, 6, 7 -> {
                for(int i = 1; i <= diff; i++) {
                    int currTile = 0;
                    if(source > dest) currTile = source - i;
                    else currTile = source + i;
                    boolean pieceInPath = grid[currTile].hasPiece();
                    boolean isDest = (currTile == dest);
                    boolean sameColor = false;
                    if(pieceInPath && isDest) {
                        sameColor = grid[source].getPiece().getColor() != grid[currTile].getPiece().getColor();
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
        int diff = dest - source;
        // diagonal top right = 7 * rows
        // diagonal top left = 9 * rows
        // diagonal bottom right = -7 * rows
        // diagonal bottom left = -9 * rows
        switch (diff) {
            case 7, 9, 14, 18, 21, 27, 28, 36, 35, 45, 42, 54, 49, -7, -9, -14, -18, -21, -27, -28, -36, -35, -45, -42, -54, -49 -> {
                if (grid[source + diff].hasPiece())
                    return grid[source].getPiece().getColor() != grid[source + diff].getPiece().getColor();
                else return true;
            }
        }
        return false;
    }

    private boolean knightPathTo(int source, int dest) {
        // 1d array math method
        int diff = dest - source;
        // top rights, = +16+1, +8+2
        // top lefts = +16-1, +8-2
        //bottom rights, = -16+1, -8+2
        //bottom lefts = -16-1, -8-2
        switch (diff) {
            case 17, 10, 15, 6, -15, -6, -17, -10 -> {
                if (grid[source + diff].hasPiece())
                    return grid[source].getPiece().getColor() != grid[source + diff].getPiece().getColor();
                else return true;
            }
        }
        return false;
    }
}
