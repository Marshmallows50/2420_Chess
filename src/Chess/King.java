package Chess;

import javax.swing.*;

public class King extends Piece{
    public King(boolean color, String rank) {
        super(color, rank, new ImageIcon("src/Chess/Resources/King.png"));
    }
}
