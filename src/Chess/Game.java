package Chess;

import java.util.ArrayList;

public class Game {
    public Board board;
    public Player white;
    public Player black;

    public boolean isWhitesTurn = true;
    public MovementManager moveManager;

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

        moveManager = new MovementManager(board.grid);
    }

    /**
     * Determines whether the Piece on Tile <code>source</code> can
     * move to Tile <code>dest</code>.
     * @param source The Tile the Piece is on.
     * @param dest The Tile the Piece wants to move to.
     * @return true if movement is legal, and false otherwise.
     */
    public boolean isValidMovement(Tile source, Tile dest) {
        return moveManager.pieceHasPathTo(source, dest) && checkCheck(source, dest);
    }


    /**
     * Determines if a player is in check by checking if the Piece on
     * Tile <code>source</code> has a path to the king of the opposite
     * color. If it does, sets the player.isInCheck boolean to true.
     * <p/>
     * This method should only be called after a Piece has moved that turn.
     * @param source The Tile with the piece to check.
     */
    //NOTE: this is unused for now, will be used in future for visual indicator
    public void determineIfInCheck(Tile source) {
        if(isWhitesTurn && (moveManager.pieceHasPathTo(source, black.king.cords)))
            black.isInCheck = true;
        else if(!isWhitesTurn && (moveManager.pieceHasPathTo(source, white.king.cords)))
            white.isInCheck = true;
    }

    /**
     * "Kills" Piece <code>p</code> by removing it from the player's
     * (of the same color as <code>p</code>) alive list and adding it
     * to their dead list.
     * @param p The Piece to kill.
     */
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

    /**
     * Determines whether the King will be in check after the Piece on
     * Tile <code>source</code> moves to Tile <code>dest</code>.
     * @param source The Tile the Piece is on.
     * @param dest The Tile the Piece wants to move to.
     * @return true if the piece is safe to move, and false otherwise
     */
    private boolean checkCheck(Tile source, Tile dest) { //TODO: this is slow and inefficient, fix.
        //needed vars and objects
        boolean canMove = true;
        boolean hadPiece = dest.hasPiece();
        Piece previous = null;

        // get the previous piece, if applicable
        if (hadPiece)
            previous = dest.getPiece();

        // temporarily move piece to dest to allow for testing paths
        source.movePieceTo(dest); //note: we have already determined that source hasPathTo dest

        // get the current player's king's tile and living opposing pieces
        Tile kingTile = isWhitesTurn ? white.king.cords : black.king.cords;
        ArrayList<Piece> opposingPieces = isWhitesTurn ? black.alive : white.alive;

        //check if any opposing piece can reach the king. If yes, canMove = false.
        for (Piece p: opposingPieces) {
            if (moveManager.pieceHasPathTo(p.cords, kingTile))
                canMove = false;
        }

        //Undo changes made to board.
        dest.movePieceTo(source);
        if (hadPiece)
            dest.setPiece(previous);

        return canMove; //note: canMove is true by default.
    }
}
