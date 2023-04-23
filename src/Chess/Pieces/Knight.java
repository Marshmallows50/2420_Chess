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
            if(color)
                image = ImageIO.read(new File("src/Chess/Resources/WhiteKnight.png"));
            else
                image = ImageIO.read(new File("src/Chess/Resources/BlackKnight.png"));
        } catch (IOException ignored) {}
    }
}
