package Chess;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;

public class TileBFPsManager {

    public TileSymbolGraph tsg;
    public TileBFPsManager(TileSymbolGraph tsg) {
        this.tsg = tsg;
    }

    public boolean pieceHasPathTo(Tile source, Tile dest) {
        Iterable<Integer> i = piecePathTo(source, dest);
        if(i == null)
            return false;
        else
            return true;
    }

    public Iterable<Integer> piecePathTo(Tile source, Tile dest) {
        int s = tsg.indexOf(source);
        int v = tsg.indexOf(dest);
        Iterable<Integer> tiles = null;
        switch (source.getPiece().rank) {
            case PAWN -> tiles = pawnPathTo(s,v);
            case QUEEN -> tiles = queenPathTo(s,v);
            case KING -> tiles = kingPathTo(s,v);
            case ROOK -> tiles = rookPathTo(s,v);
            case BISHOP -> tiles = bishopPathTo(s,v);
        }
        return tiles;
    }

    private Iterable<Integer> pawnPathTo(int source, int dest) {
        BreadthFirstPaths BFP = new BreadthFirstPaths(tsg.graph(), source);
        Stack<Integer> thing = (Stack<Integer>) BFP.pathTo(dest);
        //TODO loop through thing and determine if a pawn can actually get there
        // considering the pawns movement length, patterns, and obstacles.
        Tile[] allTiles = tsg.getKeys();
        if(thing.size() == 1 || (thing.size() == 2 && !tsg.tileOf(source).getPiece().hasMoved)) {
            System.out.println("Pawn can move there.");
            return thing;
        } else {
            System.out.println("Pawn can't move there.");
            return null;
        }
    }

    private Iterable<Integer> kingPathTo(int source, int dest) {
        return null; // TODO: NO The king is gonna suck to impliment because it's a fucking loser
        // Get friends king; jk, you're too much of a loser to achieve friends.
        /* A Story:
        One day I went to the store and saw the King crying alone by himself. I went up to him,
        not ask what was wrong, but to punch him in the face because he fucking sucks. His guards somehow
        didn't notice me until than and I was immediatley tackled. However, I was released as a jury was unable to convict
        me due to them not caring the king was assaulted because he's such a loser. Twenty Years later, I learned the
        the king kept a picture of me over his bed. I found this out when I snuck in to his room to assassinate him (unrelated).
        Turns out, he had been plotting revenge all this time, and hired me to assassinate himself, not because
        he was a loser as you might think, but to lure me into a trap. Luckily, my friend and acompliace: Queen, cut
        me free and in fact stabbed the king with the very same blade. However, the king: being such a loser,
        always carries around a dvd boxset of the star wars prequels. The knife skimmed the wrapping,
        ruining the mint condition movie set. Absolutley saddened by the destruction of his favorite item,
        the king git commit suicide, thus making the world a better place.
         The end. */
        // I am tired
    }

    private Iterable<Integer> queenPathTo(int source, int dest) {
        return null;
    }

    private Iterable<Integer> rookPathTo(int source, int dest) {
        // Please kill me I want to die, jk I don't wanna be killed: I just wanna commit suicide.
        // LMAO
        /*
        I'm tired I'm tired I'm tired I'm tried I'm tired I'm tired I"m tired I'm tired I"m tired
        i"m tired I'm tired I'm tired I'm tried I'm tired I"m tired I"m tired I'm tired I'm tired
        I'm tired I'm tired I'm tired I'm tired I"m tired I'm tied I'm tired I'm tired I'm tired
        I'm tired I'm tired I"m tired I"m ited I"m Itedi "im te daI"m te dire I"m ted I"mted
        I'm tired I"m tired I"mted I'm ttedI'mte dI'mte I"m tired I"m tired I"m tired I'm tired
        I'm tired I'm tired I"m tired I"m tried I'm tried I'm tired I"m tired I'm ted I'm Ited
        I am tired I'm tired I"m trd I'm tried I"m tired I"m tired I'm tired I'm tired I'm tired I'm tire
        I'm tired I'm Itred I'm Itred I'm tired i'm tired I"m Tired I'm Tired I'm Tired I'm Tired
        I"m tired I'm tired I'm tired I'm tired I'm tired I'm tired
         */
        return null;
    }

    private Iterable<Integer> bishopPathTo(int source, int dest) {
        BreadthFirstPaths BFP = new BreadthFirstPaths(tsg.graph(), source);

        return null;
    }


}
