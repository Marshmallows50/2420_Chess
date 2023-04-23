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
        if(path == null)
            return false;

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
        // determine if dest is in a straight line
        if(tsg.tileOf(source).getName().substring(0,1).equals(tsg.tileOf(dest).getName().substring(0,1))) {
            System.out.println(tsg.tileOf(source).getPiece().hasMoved);
            // Pawn has not moved and the distance to the destination tile is 2 or 1.
            if (!tsg.tileOf(source).getPiece().hasMoved && BFP.distTo(dest) <= 2)
                return thing;
            else if (BFP.distTo(dest) == 1)
                return thing;
        }
        return null;
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
