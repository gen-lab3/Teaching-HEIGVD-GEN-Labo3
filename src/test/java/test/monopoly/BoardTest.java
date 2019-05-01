package test.monopoly;

import monopoly.Board;
import monopoly.Piece;
import monopoly.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    static ArrayList<Square> squares;
    static Board board;

    @BeforeEach
    public void InitBoard() throws NoSuchFieldException, IllegalAccessException {
        board = new Board();

        // Get board private field
        Field field = board.getClass().getDeclaredField("squares");
        field.setAccessible(true);
        squares = (ArrayList<Square>)field.get(board);
    }

    @Test
    public void newLocationIsTheRightOne() {
        Piece piece = new Piece("T-Rex");
        piece.setLocation(board.getStartSquare());


        assertNotSame(board.getSquare(piece.getLocation(), 39), board.getStartSquare());
        assertSame(board.getSquare(piece.getLocation(), 41), squares.get(1));

        assertSame(board.getSquare(piece.getLocation(), 4), squares.get(4));
        piece.setLocation(board.getSquare(piece.getLocation(), 4));
        assertSame(board.getSquare(piece.getLocation(), 2), squares.get(6));
    }

    @Test
    public void checkBoardSize(){
        assertEquals(board.BOARD_SIZE, squares.size());
    }

    @Test
    public void startSquareHasRightName(){
        assertEquals(board.START_NAME, board.getStartSquare().getName());
    }
}
