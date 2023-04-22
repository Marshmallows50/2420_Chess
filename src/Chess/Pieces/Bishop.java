package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Bishop extends Piece {
    public Bishop(boolean color) {
        super(color);
        rank = Rank.BISHOP;
        try {
            image = ImageIO.read(new File("src/Chess/Resources/Bishop.png"));
        } catch (IOException ignored) {}
    }
}
