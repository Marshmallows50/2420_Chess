package Chess;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Board {
    public TileSymbolGraph grid;
    public Graph gridGraph;
    public Tile selectedTile;


    public Board() {
        // create Players
        Player white = new Player(true);
        Player black = new Player(false);

        // create Graph
        grid = new TileSymbolGraph("src/Chess/Resources/tileConnections.txt", ",");
        gridGraph = grid.graph();

        //Add Pieces to Graph
        Tile[] allTiles = grid.getKeys();

        //color true = white, false = black
        allTiles[0].setPiece(new Rook(true, "Rook"));
        allTiles[1].setPiece(new Knight(true, "Knight"));
        allTiles[2].setPiece(new Bishop(true, "Bishop"));
        allTiles[3].setPiece(new Queen(true, "Queen"));
        allTiles[4].setPiece(new King(true, "King"));
        allTiles[5].setPiece(new Bishop(true, "Bishop"));
        allTiles[6].setPiece(new Bishop(true, "Knight"));
        allTiles[7].setPiece(new Rook(true, "Rook"));

        for (int i = 8; i < 16; i++)//TODO change so it's not magic number
            allTiles[i].setPiece(new Pawn(true, "Pawn"));

        for (int i = 48; i < 56; i++)//TODO change so it's not magic number
            allTiles[i].setPiece(new Pawn(false, "Pawn"));

        allTiles[56].setPiece(new Rook(false, "Rook"));
        allTiles[57].setPiece(new Knight(false, "Knight"));
        allTiles[58].setPiece(new Bishop(false, "Bishop"));
        allTiles[59].setPiece(new Queen(false, "Queen"));
        allTiles[60].setPiece(new King(false, "King"));
        allTiles[61].setPiece(new Bishop(false, "Bishop"));
        allTiles[62].setPiece(new Bishop(false, "Knight"));
        allTiles[63].setPiece(new Rook(false, "Rook"));
    }

    public boolean hasPathTo(Tile piece, Tile destination) {
        return false; // TODO: Need to implement.
    }

    public void select(Tile selectedTile) {
        this.selectedTile = selectedTile;
    }

    public static void main(String[] args) {
        Board board = new Board();
    }
}
