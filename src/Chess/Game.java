package Chess;

import Chess.Pieces.Rank;
import edu.princeton.cs.algs4.BreadthFirstPaths;

public class Game {
    public Board board;
    public Player white;
    public Player black;

    public boolean isWhitesTurn = true;
    public TileBFPsManager bfpsManager;
    public Tile blackKingTile;
    public Tile whiteKingTile;

    //TODO integrate TileBFPsManager into game rather than using it directly
    public Game() {

        board = new Board();
        white = new Player(true, board.grid.tileOf(4).getPiece());
        black = new Player(false, board.grid.tileOf(60).getPiece());
        bfpsManager = new TileBFPsManager(board.grid);

    }

    public boolean isValidMovement(Tile source, Tile dest) {
//        for(int i = 0; i < board.grid2d.length; i++) {
//            for(int j = 0; j < board.grid2d[i].length; j++) {
//                if(board.grid2d[i][j].hasPiece())
//                    if(board.grid2d[i][j].getPiece().rank == Rank.KING)
//                        if(board.grid2d[i][j].getPiece().getColor()) whiteKingTile = board.grid2d[i][j];
//                        else blackKingTile = board.grid2d[i][j];
//            }
//        }
//
//        if(isWhitesTurn && (bfpsManager.pieceHasPathTo(source, blackKingTile)))
//            System.out.println("black is in check");
//        if(!isWhitesTurn && (bfpsManager.pieceHasPathTo(source, whiteKingTile)))
//            System.out.println("white is in check");

        return bfpsManager.pieceHasPathTo(source, dest);
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
