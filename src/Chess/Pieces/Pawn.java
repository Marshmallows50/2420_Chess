package Chess.Pieces;

import Chess.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Pawn extends Piece {
    public Pawn(boolean color) {
        super(color);
        rank = Rank.PAWN;
        try {
            if(color) {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/WhitePawn.png");
                image = ImageIO.read(stream);
            }
            else {
                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Chess/Resources/BlackPawn.png");
                image = ImageIO.read(stream);
            }
        } catch (IOException ignored) {}
    }
}
