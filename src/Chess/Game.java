package Chess;

public class Game {
    public Board board;
    public Player white;
    public Player black;

    public boolean isWhitesTurn = true;
    public TileBFPsManager bfpsManager;

    //TODO integrate TileBFPsManager into game rather than using it directly
    public Game() {
        board = new Board();
        white = new Player(true);
        black = new Player(false);
        bfpsManager = new TileBFPsManager(board.grid);
    }

    public boolean isValidMovement(Tile source, Tile dest) {
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
