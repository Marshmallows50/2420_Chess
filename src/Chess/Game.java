package Chess;

public class Game {
    public Board board;
    public Player white;
    public Player black;

    public boolean isWhitesTurn = true;
    public TileBFPsManager bfpsManager;

    public Game() {
        board = new Board();
        white = new Player(true);
        black = new Player(false);
        bfpsManager = new TileBFPsManager(board.grid);
    }

    public void checkCheck() {
        //TODO implement
    }



}
