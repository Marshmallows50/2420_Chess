package Chess;

import javax.swing.*;

public class Bishop extends Piece{
    public Bishop(boolean color, String rank) {
        super(color, rank, new ImageIcon("src/Chess/Resources/Bishop.png"));
    }
}
