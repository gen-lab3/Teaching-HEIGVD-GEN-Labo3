package test.monopoly;

import monopoly.Board;
import monopoly.Piece;
import monopoly.Square;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class BoardTest {
    @Test
    public void newLocationIsTheRightOne() throws NoSuchFieldException, IllegalAccessException {
        Board board = new Board();
        Piece piece = new Piece("T-Rex");
        piece.setLocation(board.getStartSquare());

        Field field = board.getClass().getDeclaredField("squares");
        field.setAccessible(true);
        ArrayList<Square> squares = (ArrayList<Square>)field.get(board);

        assertNotSame(board.getSquare(piece.getLocation(), 39), board.getStartSquare());
        assertSame(board.getSquare(piece.getLocation(), 41), squares.get(1));

        assertSame(board.getSquare(piece.getLocation(), 4), squares.get(4));
        piece.setLocation(board.getSquare(piece.getLocation(), 4));
        assertSame(board.getSquare(piece.getLocation(), 2), squares.get(6));
    }
}
