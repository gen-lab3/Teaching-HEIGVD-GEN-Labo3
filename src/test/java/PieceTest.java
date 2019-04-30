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
        Square square = new Square("test");
        piece.setLocation(square);

        assertSame(piece.getLocation(), square);
    }

}
