package Chess;

import Chess.Pieces.*;
import edu.princeton.cs.algs4.Graph;

public class Board {
    public TileSymbolGraph grid;
    public Graph gridGraph;
    public Tile selectedPieceTile = null;
    public Tile[][] grid2d;

    public Board() { //TODO combine with Game.java
        // create Graph
        grid = new TileSymbolGraph("src/Chess/Resources/tileConnections.txt", ",");
        gridGraph = grid.graph();
        grid2d = new Tile[8][8];

        //Add Tiles to 2d grid
        Tile[] allTiles = grid.getKeys();
        for (int i = 0, j= 0, k=0;k < gridGraph.V(); j++, k++) {
            grid2d[i][j] = allTiles[k];
            if (j == 7) {
                i++;
                j = -1;
            }
        }

        //Add Pieces to Graph
        //color true = white, false = black
        allTiles[0].setPiece(new Rook(true));
        allTiles[1].setPiece(new Knight(true));
        allTiles[2].setPiece(new Bishop(true));
        allTiles[3].setPiece(new Queen(true));
        allTiles[4].setPiece(new King(true));
        allTiles[5].setPiece(new Bishop(true));
        allTiles[6].setPiece(new Knight(true));
        allTiles[7].setPiece(new Rook(true));

        for (int i = 8; i < 16; i++)//TODO change so it's not a 'magic number'
            allTiles[i].setPiece(new Pawn(true));

        for (int i = 48; i < 56; i++)//TODO change so it's not a 'magic number'
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
}
