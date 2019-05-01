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

    @Test
    public void GoSquareGive200ToPlayer() {
        Board board = new Board();
        Player player = new Player("test", board);

        int cash = player.getNetWorth();
        player.getPiece().getLocation().landedOn(player);

        assertEquals(cash+200, player.getNetWorth());
    }

    @Test
    public void IncomeTaxIs200WhenPlayer10PercentOfPlayerWorthIsMoreThan200() {
        Board board = new Board();
        Player player = new Player("test", board);

        player.addCash(5000);
        int cash = player.getNetWorth();
        player.getPiece().setLocation(board.getSquare(board.getStartSquare(), 20));
        player.getPiece().getLocation().landedOn(player);

        assertEquals(cash - 200, player.getNetWorth());
    }

    @Test
    public void IncomeTaxIs10PercentOfPlayerWorthWhenPlayer10PercentWorthIsLessThan200() {
        Board board = new Board();
        Player player = new Player("test", board);

        player.reduceCash(player.getNetWorth() > 0 ? player.getNetWorth() : 0);
        player.addCash(300);
        int cash = player.getNetWorth();
        player.getPiece().setLocation(board.getSquare(board.getStartSquare(), 20));
        player.getPiece().getLocation().landedOn(player);

        assertEquals(cash - 0.1 * cash, player.getNetWorth());
    }
}
