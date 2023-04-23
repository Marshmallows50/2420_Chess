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

    public boolean pieceHasPathTo(Tile source, Tile dest) {
        Stack<Integer> path = (Stack<Integer>) piecePathTo(source, dest);
        for (int v : path) {
            if(tsg.tileOf(v).hasPiece() && !tsg.tileOf(v).equals(source)) {
                // check the color
            }
        }
        while (!path.isEmpty()) {
            Tile tile = tsg.tileOf(path.pop());
            if(!tile.equals(source) || !tile.equals(dest)) {
                if(tile.hasPiece() && (tile.getPiece().getColor() != source.getPiece().getColor()))
                    return false;
            }
        }
        return true;
    }

    public Iterable<Integer> piecePathTo(Tile source, Tile dest) {
        int s = tsg.indexOf(source);
        int v = tsg.indexOf(dest);
        Iterable<Integer> tiles = null;
        switch (source.getPiece().rank) {
            case PAWN -> tiles = pawnPathTo(s,v);
            case QUEEN -> tiles = queenPathTo(s,v);
            case KING -> tiles = kingPathTo(s,v);
            case ROOK -> tiles = rookPathTo(s,v);
            case BISHOP -> tiles = bishopPathTo(s,v);
        }
        return tiles;
    }

    private Iterable<Integer> pawnPathTo(int source, int dest) {
        BreadthFirstPaths BFP = new BreadthFirstPaths(tsg.graph(), source);
        // first vertex accessed is the source, last vertex is the destination.
        Stack<Integer> thing = (Stack<Integer>) BFP.pathTo(dest);
        if(tsg.tileOf(dest).hasPiece()) {
            // capture
        } else if(!tsg.tileOf(dest).hasPiece()) {
            if ((tsg.tileOf(source).getPiece().hasMoved && BFP.distTo(dest) > 2) || BFP.distTo(dest) > 2)
                return null;
        } else {


        }

        return thing;
    }

    private Iterable<Integer> kingPathTo(int source, int dest) {
        return null; // TODO: NO
    }

    private Iterable<Integer> queenPathTo(int source, int dest) {
        return null;
    }

    private Iterable<Integer> rookPathTo(int source, int dest) {
        return null;
    }

    private Iterable<Integer> bishopPathTo(int source, int dest) {
        BreadthFirstPaths BFP = new BreadthFirstPaths(tsg.graph(), source);

        return null;
    }


}
