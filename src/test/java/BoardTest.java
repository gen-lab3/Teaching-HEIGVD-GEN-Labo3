
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    @ParameterizedTest
    @ValueSource(ints = {40})
    public void ABoardShouldHaveANumberOfSquares(int candidate){
        Board board = new Board();

        assertEquals(candidate, board.getSize());
    }
}
