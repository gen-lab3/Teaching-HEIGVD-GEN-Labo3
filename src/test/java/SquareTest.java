import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {
    @Test
    public void squareNameIsTheRightOne() {
        String name = "SuperSquare";
        Square square = new Square(name);

        assertEquals(square.getName(), name);
    }
}
