package Chess;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Board {
    public Graph grid;
    private Tile selectedTile;


    public Board() {
        // create Players
        Player white = new Player(true);
        Player black = new Player(false);

        // TODO create and populate board
//        In in = new In("src/Chess/Resources/tileConnections.txt");
        TileSymbolGraph TSG = new TileSymbolGraph("src/Chess/Resources/tileConnections.txt", ",");
        Graph graph = TSG.graph();
    }

    public boolean hasPathTo(Tile piece, Tile destination) {
        return false; // TODO: Need to implement.
    }

    public void select(Tile selectedTile) {
        this.selectedTile = selectedTile;
    }

    public static void main(String[] args) {
        Board b = new Board();
    }
}
