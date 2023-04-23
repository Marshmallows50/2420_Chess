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
            if(color)
                image = ImageIO.read(new File("src/Chess/Resources/WhiteQueen.png"));
            else
                image = ImageIO.read(new File("src/Chess/Resources/BlackQueen.png"));
        } catch (IOException ignored) {}
    }
}
