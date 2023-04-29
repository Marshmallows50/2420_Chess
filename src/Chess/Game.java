package Chess;

import Chess.Pieces.Rank;
import edu.princeton.cs.algs4.BreadthFirstPaths;

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
        bfpsManager = new TileBFPsManager(board.grid);

    }

    public boolean isValidMovement(Tile source, Tile dest) {
        return bfpsManager.pieceHasPathTo(source, dest);
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
        if (p.getColor())
            white.dead.add(p);
        else
            black.dead.add(p);
    }

    public void checkCheck() {
        //TODO implement
    }



}
