package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Rook extends Piece {
    public Rook(boolean color) {
        super(color);
        rank = Rank.ROOK;
        try {
            if(color) {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/WhiteRook.png");
                image = ImageIO.read(stream);
            }
            else{
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/BlackRook.png");
                image = ImageIO.read(stream);
            }

        } catch (IOException ignored) {}
    }
}
