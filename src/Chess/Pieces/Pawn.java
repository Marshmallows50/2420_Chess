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
            if(color)
                image = ImageIO.read(new File("src/Chess/Resources/WhitePawn.png"));
            else
                image = ImageIO.read(new File("src/Chess/Resources/BlackPawn.png"));
        } catch (IOException ignored) {}
    }
}
