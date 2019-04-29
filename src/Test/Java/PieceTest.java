import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    public void pieceShouldHaveAName(){
        Piece piece = new Piece("T-Rex");

        assertEquals("T-Rex", piece.getName());
    }

}
