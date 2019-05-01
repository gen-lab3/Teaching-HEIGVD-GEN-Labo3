package test.monopoly;

import monopoly.Board;
import monopoly.Player;
import monopoly.RegularSquare;
import monopoly.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SquareTest {
    @Test
    public void squareNameIsTheRightOne() {
        String name = "SuperSquare";
        Square square = new RegularSquare(name);

        assertEquals(square.getName(), name);
    }

    @Test
    public void GoToJailSquareMovesPlayerToJail() {
        Board board = new Board();
        Player player = new Player("test", board);

        player.getPiece().setLocation(board.getSquare(board.getStartSquare(), 30));
        player.getPiece().getLocation().landedOn(player);

        assertSame(
                board.getSquare(board.getStartSquare(), 10),
                player.getPiece().getLocation()
        );
    }
}
