package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Rook extends Piece {
    public Rook(boolean color) {
        super(color);
        rank = Rank.ROOK;
        try {
            if(color)
                image = ImageIO.read(new File("src/Chess/Resources/WhiteRook.png"));
            else
                image = ImageIO.read(new File("src/Chess/Resources/BlackRook.png"));
        } catch (IOException ignored) {}
    }
}
