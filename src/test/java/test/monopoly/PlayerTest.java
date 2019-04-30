package test.monopoly;

import monopoly.*;
import org.junit.jupiter.api.Test;
import test.monopoly.mock.MockDie;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void APlayerShouldHaveAName(){
        String name = "John";
        Player player = new Player(name, null);
        assertEquals(player.getName(), name);
    }

    @Test
    public void APlayerShouldHaveAPiece(){
        Player player = new Player(null, null);

        assertNotNull(player.getPiece());
    }

    @Test
    public void APlayerCanTakeTurn() throws NoSuchFieldException, IllegalAccessException {
        Die[] mockDice = {
                new MockDie(1, 6, 2),
                new MockDie(4, 6, 5)
        };

        Board board = new Board();
        Player player = new Player("jean", board);

        // Get board private field
        Field field = board.getClass().getDeclaredField("squares");
        field.setAccessible(true);
        ArrayList<Square> squares = (ArrayList<Square>)field.get(board);


        player.takeTurn(mockDice);

        assertSame(squares.get(12),
                player.getPiece().getLocation());


        player.takeTurn(mockDice);

        assertSame(squares.get(19),
                player.getPiece().getLocation());


        player.takeTurn(mockDice);

        assertSame(squares.get(24),
                player.getPiece().getLocation());

    }

    @Test
    public void APlayerCanMakeMultipleTurn() throws NoSuchFieldException, IllegalAccessException {
        Die[] mockDice = {
                new MockDie(21),
                new MockDie(20)
        };

        Board board = new Board();
        Player player = new Player("jean", board);

        // Get board private field
        Field field = board.getClass().getDeclaredField("squares");
        field.setAccessible(true);
        ArrayList<Square> squares = (ArrayList<Square>)field.get(board);

        player.takeTurn(mockDice);

        assertSame(squares.get(1),
                player.getPiece().getLocation());

        player.takeTurn(mockDice);

        assertSame(squares.get(2),
                player.getPiece().getLocation());
    }
}
