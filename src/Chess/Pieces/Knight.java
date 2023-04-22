package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Knight extends Piece {
    public Knight(boolean color) {
        super(color);
        rank = Rank.KNIGHT;
        try {
            image = ImageIO.read(new File("src/Chess/Resources/Knight.png"));
        } catch (IOException ignored) {}
    }
}
