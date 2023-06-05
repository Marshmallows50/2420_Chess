package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Queen extends Piece {
    public Queen(boolean color) {
        super(color);
        rank = Rank.QUEEN;
        try {
            if(color) {

                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/WhiteQueen.png");
                image = ImageIO.read(stream);
            }
            else {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/BlackQueen.png");
                image = ImageIO.read(stream);
            }
        } catch (IOException ignored) {}
    }
}
