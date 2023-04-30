package Chess;

import Chess.Pieces.Queen;
import Chess.Pieces.Rank;
import edu.princeton.cs.algs4.BreadthFirstPaths;

import java.util.ArrayList;

public class Game {
    public Board board;
    public Player white;
    public Player black;

    public boolean isWhitesTurn = true;
    public TileBFPsManager bfpsManager;

    //TODO integrate TileBFPsManager into game rather than using it directly
    public Game() {

        board = new Board();
        white = new Player(true, board.grid.tileOf(4).getPiece());
        black = new Player(false, board.grid.tileOf(60).getPiece());
        for (Tile t:board.grid.getKeys()) {
            if (t.hasPiece()){
                if (t.getPiece().getColor())
                    white.alive.add(t.getPiece());
                else
                    black.alive.add(t.getPiece());
            }
        }


        bfpsManager = new TileBFPsManager(board.grid);

    }

    public boolean isValidMovement(Tile source, Tile dest) {
        return bfpsManager.pieceHasPathTo(source, dest) && checkCheck(source, dest);
    }


    /**
     * Checks if A piece has a path to the opposite color king.
     * Only call after Piece of opposite color moves.
     * @param source
     */
    public void hasPathToOppositeKing(Tile source) {
        if(isWhitesTurn && (bfpsManager.pieceHasPathTo(source, black.king.cords)))
            black.isInCheck = true;
        else if(!isWhitesTurn && (bfpsManager.pieceHasPathTo(source, white.king.cords)))
            white.isInCheck = true;
    }

    public void kill(Piece p) {
        System.out.println(p.getColor() + " " + p.rank + " was captured");
        if (p.getColor()) {
            white.alive.remove(p);
            white.dead.add(p);
        }
        else {
            black.alive.remove(p);
            black.dead.add(p);
        }
    }

    public boolean checkCheck(Tile source, Tile dest) {
        // Tile source is the piece that is moving, before it moves
        Piece previous = new Piece(isWhitesTurn);
        boolean hadPiece = dest.hasPiece();
        if (hadPiece)
            previous = dest.getPiece();
        if (bfpsManager.pieceHasPathTo(source,dest)) {
            source.movePieceTo(dest);
        } else
            return false;

        Tile kingTile = isWhitesTurn ? white.king.cords : black.king.cords;
        ArrayList<Piece> opposingPieces = isWhitesTurn ? black.alive : white.alive;

        int b;
        int w;

        for (Piece p: opposingPieces) {
            if (bfpsManager.pieceHasPathTo(p.cords, kingTile)) {
                dest.movePieceTo(source);
                if (hadPiece)
                    dest.setPiece(previous);
                b = board.grid.indexOf(black.king.cords);
                w = board.grid.indexOf(white.king.cords);
                System.out.println("black king tile: " + board.grid.nameOf(b));
                System.out.println("white king tile: " + board.grid.nameOf(w));
                return false;
            }
        }
        dest.movePieceTo(source);
        if (hadPiece)
            dest.setPiece(previous);
        b = board.grid.indexOf(black.king.cords);
        w = board.grid.indexOf(white.king.cords);
        System.out.println("black king tile: " + board.grid.nameOf(b));
        System.out.println("white king tile: " + board.grid.nameOf(w));

        return true;

//        Tile kingTile;
//        boolean isKing = source.getPiece().rank == Rank.KING;
//
//        if (isKing)
//            kingTile = dest;
//        else
//            kingTile = isWhitesTurn ? white.king.cords : black.king.cords;
//
//        ArrayList<Piece> opposingPieces = isWhitesTurn ? black.alive : white.alive;
//
//        Piece tempSource = source.getPiece();
//        Piece tempDest = source.getPiece();
//        source.piece = null;
//
//        if (isKing)
//            dest.piece = null;
//
//        for (Piece p: opposingPieces) {
//            if (bfpsManager.pieceHasPathTo(p.cords, kingTile)) {
//                source.setPiece(tempSource);
//                dest.setPiece(tempDest);
//                return false;
//            }
//        }
//        source.setPiece(tempSource);
//        dest.setPiece(tempDest);
//        return true;
    }



}
