package Chess;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class Board {
    public Graph grid;
    private Tile selectedTile;


    public Board() {
        // create Players
        Player white = new Player(true);
        Player black = new Player(false);

        // TODO create and populate board
    }

    public boolean hasPathTo(Tile piece, Tile destination) {
        return false; // TODO: Need to implement.
    }

    public void select(Tile selectedTile) {
        this.selectedTile = selectedTile;
    }
}
