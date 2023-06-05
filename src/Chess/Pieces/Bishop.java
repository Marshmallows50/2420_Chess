package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Bishop extends Piece {
    public Bishop(boolean color) {
        super(color);
        rank = Rank.BISHOP;
        try {
            if(color) {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/WhiteBishop.png");
                image = ImageIO.read(stream);
            }
            else {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/BlackBishop.png");
                image = ImageIO.read(stream);
            }
        } catch (IOException ignored) {}
    }
}
