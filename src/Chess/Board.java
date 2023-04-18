package Chess;

import edu.princeton.cs.algs4.Graph;

public class Board {
    public Graph grid;
    public Graph pieces;
    private Node selectedTile;


    public Board() {
        //TODO
    }

    public boolean hasPathTo(Node piece, Node destination) {
        return false; // TODO: Need to implement.
    }

    public void select(Node selectedTile) {
        this.selectedTile = selectedTile;
    }
}
