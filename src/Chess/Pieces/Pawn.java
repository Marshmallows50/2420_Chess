package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Pawn extends Piece {
    public Pawn(boolean color) {
        super(color);
        rank = Rank.PAWN;
        try {
            image = ImageIO.read(new File("src/Chess/Resources/Pawn.png"));
        } catch (IOException ignored) {}
    }
}
