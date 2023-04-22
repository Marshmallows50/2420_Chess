package Chess;

import javax.swing.*;

public class Pawn extends Piece{
    public Pawn(boolean color, String rank) {
        super(color, rank, new ImageIcon("src/Chess/Resources/Pawn.png"));
    }
}
