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
//            case QUEEN -> tiles = queenPathTo(s,v);
            case KING -> tiles = kingPathTo(s,v);
//            case ROOK -> tiles = rookPathTo(s,v);
//            case BISHOP -> tiles = bishopPathTo(s,v);
            case KNIGHT -> tiles = knightPathTo(s,v);
        }
        return tiles;
    }

    private boolean pawnPathTo(int source, int dest) {
        // 1d array math method
        int diff = dest - source;
        switch (diff) {
            case 8, -8 -> {
                return !grid[source + diff].hasPiece();
            }
            case 7, 9 -> {
                return grid[source + diff].hasPiece() && !grid[source + diff].getPiece().getColor();
            }
            case -7, -9 -> {
                return grid[source + diff].hasPiece() && grid[source + diff].getPiece().getColor();
            }
            case 16, -16 -> {
                return !grid[source + diff].hasPiece() && !tsg.tileOf(source).getPiece().hasMoved;
            }
        }
        return false;
    }

    private boolean kingPathTo(int source, int dest) {
        return false; // TODO: NO
    }

//    private boolean queenPathTo(int source, int dest) {
//        Stack<Integer> thing = (Stack<Integer>) rookPathTo(source, dest);
//        if(thing == null)
//            return bishopPathTo(source, dest);
//        else
//            return thing;
//    }

//    private boolean rookPathTo(int source, int dest) {
//        BreadthFirstPaths BFP = new BreadthFirstPaths(tsg.graph(), source);
//        // first vertex accessed is the source, last vertex is the destination.
//        Stack<Integer> thing = (Stack<Integer>) BFP.pathTo(dest);
//        // determine if dest is in a straight line
//        if(tsg.tileOf(source).getName().substring(0,1).equals(tsg.tileOf(dest).getName().substring(0,1)))
//            return thing;
//        else if(tsg.tileOf(source).getName().substring(1).equals(tsg.tileOf(dest).getName().substring(1)))
//            return thing;
//
//        return false;
//    }

//    private boolean bishopPathTo(int source, int dest) {
//        BreadthFirstPaths BFP = new BreadthFirstPaths(tsg.graph(), source);
//        Stack<Integer> thing = (Stack<Integer>) BFP.pathTo(dest);
//        if(tsg.tileOf(source).getColor().equals(tsg.tileOf(dest).getColor()))
//            return thing;
//        return false;
//    }

    private boolean knightPathTo(int source, int dest) {
        int diff = dest - source;
        // top rights, = +16+1, +8+2
        // top lefts = +16-1, +8-2
        //bottom rights, = -16+1, -8+2
        //bottom lefts = -16-1, -8-2
        switch (diff) {
            case 17, 10, 15, 6, -15, -6, -17, -10-> {
                if (grid[source + diff].hasPiece())
                    return grid[source].getPiece().getColor() != grid[source + diff].getPiece().getColor();
                else return true;
            }
        }
        return false;
    }
}
