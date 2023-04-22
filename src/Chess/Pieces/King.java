package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class King extends Piece {
    public King(boolean color) {
        super(color);
        rank = Rank.KING;
        try {
            image = ImageIO.read(new File("src/Chess/Resources/King.png"));
        } catch (IOException ignored) {}
    }
}
