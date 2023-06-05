package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class King extends Piece {
    public King(boolean color) {
        super(color);
        rank = Rank.KING;
        try {
            if(color) {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/WhiteKing.png");
                image = ImageIO.read(stream);
            }
            else{
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/BlackKing.png");
                image = ImageIO.read(stream);
            }
        } catch (IOException ignored) {}
    }
}
