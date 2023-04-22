package Chess;

import javax.swing.*;

public class Queen extends Piece{
    public Queen(boolean color, String rank) {
        super(color, rank, new ImageIcon("src/Chess/Resources/Queen.png"));
    }
}
