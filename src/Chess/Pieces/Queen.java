package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Queen extends Piece {
    public Queen(boolean color) {
        super(color);
        rank = Rank.QUEEN;
        try {
            image = ImageIO.read(new File("src/Chess/Resources/Queen.png"));
        } catch (IOException ignored) {}
    }
}
