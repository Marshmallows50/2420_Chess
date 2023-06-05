package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Knight extends Piece {
    public Knight(boolean color) {
        super(color);
        rank = Rank.KNIGHT;
        try {
            if(color) {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/WhiteKnight.png");
                image = ImageIO.read(stream);
            }
            else {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/BlackKnight.png");
                image = ImageIO.read(stream);
            }
        } catch (IOException ignored) {}
    }
}
