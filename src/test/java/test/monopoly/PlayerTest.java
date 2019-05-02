package test.monopoly;

import monopoly.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.monopoly.mock.MockCup;
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

        player.takeTurn(new MockCup(6, 6));

        assertSame(squares.get(12),
                player.getPiece().getLocation());


        player.takeTurn(new MockCup(2, 5));

        assertSame(squares.get(19),
                player.getPiece().getLocation());


        player.takeTurn(new MockCup(1, 4));

        assertSame(squares.get(24),
                player.getPiece().getLocation());

    }

    @Test
    public void APlayerCanMakeMultipleTurn() throws NoSuchFieldException, IllegalAccessException {
        Cup cup = new MockCup(21, 20);

        Player player = new Player("jean", board);

        player.takeTurn(cup);

        assertSame(squares.get(1),
                player.getPiece().getLocation());

        player.takeTurn(cup);

        assertSame(squares.get(2),
                player.getPiece().getLocation());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1500, 200, Integer.MAX_VALUE})
    public void APlayerCanGetCash(int cash){
        Player player = new Player("John", board);

        player.addCash(cash);

        assertEquals(cash, player.getNetWorth());
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 1500})
    public void APlayerCanLoseCash(int cash){
        Player player = new Player("John", board);

        player.addCash(cash);

        int wealth = player.getNetWorth();

        int amountToLose = 200;

        player.reduceCash(amountToLose);

        int remaining = wealth - amountToLose;

        assertEquals(remaining, player.getNetWorth());

    }

    @Test
    public void APlayerCannotHaveANegativeWealth(){
        Player player = new Player("Merin", board);

        player.addCash(100);

        player.reduceCash(1000);

        assertEquals(0, player.getNetWorth());
    }
}
