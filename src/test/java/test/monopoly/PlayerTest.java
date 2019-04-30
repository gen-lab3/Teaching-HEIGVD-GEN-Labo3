package test.monopoly;

import monopoly.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.monopoly.mock.MockDie;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    static ArrayList<Square> squares;
    static Board board;

    @BeforeAll
    public static void InitBoard() throws NoSuchFieldException, IllegalAccessException {
        board = new Board();

        // Get board private field
        Field field = board.getClass().getDeclaredField("squares");
        field.setAccessible(true);
        squares = (ArrayList<Square>)field.get(board);
    }


    @Test
    public void APlayerShouldHaveAName(){
        String name = "John";
        Player player = new Player(name, board);
        assertEquals(player.getName(), name);
    }

    @Test
    public void APlayerShouldHaveAPiece(){
        Player player = new Player(null, board);

        assertNotNull(player.getPiece());
    }

    @Test
    public void APlayerCanTakeTurn() throws NoSuchFieldException, IllegalAccessException {
        Player player = new Player("jean", board);

        player.takeTurn(new MockDie(6), new MockDie(6));

        assertSame(squares.get(12),
                player.getPiece().getLocation());


        player.takeTurn(new MockDie(2), new MockDie(5));

        assertSame(squares.get(19),
                player.getPiece().getLocation());


        player.takeTurn(new MockDie(1), new MockDie(4));

        assertSame(squares.get(24),
                player.getPiece().getLocation());

    }

    @Test
    public void APlayerCanMakeMultipleTurn() throws NoSuchFieldException, IllegalAccessException {
        Die[] mockDice = {
                new MockDie(21),
                new MockDie(20)
        };

        Player player = new Player("jean", board);

        player.takeTurn(mockDice);

        assertSame(squares.get(1),
                player.getPiece().getLocation());

        player.takeTurn(mockDice);

        assertSame(squares.get(2),
                player.getPiece().getLocation());
    }
}
