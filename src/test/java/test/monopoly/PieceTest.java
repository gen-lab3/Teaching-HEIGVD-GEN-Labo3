package test.monopoly;

import monopoly.Piece;
import monopoly.RegularSquare;
import monopoly.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PieceTest {

    @Test
    public void pieceShouldHaveAName(){
        Piece piece = new Piece("T-Rex");

        assertEquals("T-Rex", piece.getName());
    }

    @Test
    public void pieceLocationIsTheRightOne() {
        Piece piece = new Piece("T-Rex");
        Square square = new RegularSquare("test");
        piece.setLocation(square);

        assertSame(piece.getLocation(), square);
    }

}
