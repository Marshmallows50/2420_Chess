package Chess;

import edu.princeton.cs.algs4.Graph;

public class Board {
    public Graph grid;
    public Graph pieces;
    private Tile selectedTile;


    public Board() {

    }

    public boolean hasPathTo(Tile piece, Tile destination) {
        return false; // TODO: Need to implement.
    }

    public void select(Tile selectedTile) {
        this.selectedTile = selectedTile;
    }
}
