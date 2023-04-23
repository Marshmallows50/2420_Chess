package Chess;

public class Game {
    public Board board;
    public Player white;
    public Player black;

    public boolean isWhitesTurn = true;

    public Game() {
        board = new Board();
        white = new Player(true);
        black = new Player(false);
    }

    public void checkCheck() {
        //TODO implement
    }



}
