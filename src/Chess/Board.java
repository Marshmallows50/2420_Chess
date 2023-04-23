package Chess;

import Chess.Pieces.*;
import edu.princeton.cs.algs4.Graph;

public class Board {
    public TileSymbolGraph grid;
    public Graph gridGraph;
    public Tile selectedTile;


    public Board() {
        // create Players


        // create Graph
        grid = new TileSymbolGraph("src/Chess/Resources/tileConnections.txt", ",");
        gridGraph = grid.graph();

        //Add Pieces to Graph
        Tile[] allTiles = grid.getKeys();

        //color true = white, false = black
        allTiles[0].setPiece(new Rook(false));
        allTiles[1].setPiece(new Knight(false));
        allTiles[2].setPiece(new Bishop(false));
        allTiles[3].setPiece(new Queen(false));
        allTiles[4].setPiece(new King(false));
        allTiles[5].setPiece(new Bishop(false));
        allTiles[6].setPiece(new Knight(false));
        allTiles[7].setPiece(new Rook(false));

        for (int i = 8; i < 16; i++)//TODO change so it's not magic number
            allTiles[i].setPiece(new Pawn(true));

        for (int i = 48; i < 56; i++)//TODO change so it's not magic number
            allTiles[i].setPiece(new Pawn(false));

        allTiles[56].setPiece(new Rook(false));
        allTiles[57].setPiece(new Knight(false));
        allTiles[58].setPiece(new Bishop(false));
        allTiles[59].setPiece(new Queen(false));
        allTiles[60].setPiece(new King(false));
        allTiles[61].setPiece(new Bishop(false));
        allTiles[62].setPiece(new Knight(false));
        allTiles[63].setPiece(new Rook(false));
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
