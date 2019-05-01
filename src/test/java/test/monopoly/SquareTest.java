package test.monopoly;

import monopoly.*;
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
        Player player = new Player("test", new Board());

        RegularSquare jail = new RegularSquare("Jail");
        player.getPiece().setLocation(new GoToJailSquare("Gtj", jail));
        player.getPiece().getLocation().landedOn(player);

        assertSame(
                jail,
                player.getPiece().getLocation()
        );
    }

    @Test
    public void GoSquareGive200ToPlayer() {
        Player player = new Player("test", new Board());

        int cash = player.getNetWorth();
        player.getPiece().getLocation().landedOn(player);

        assertEquals(cash + GoSquare.STARTCASH, player.getNetWorth());
    }

    @Test
    public void IncomeTaxIs200WhenPlayer10PercentOfPlayerWorthIsMoreThan200() {
        Player player = new Player("test", new Board());

        player.addCash(5000);
        int cash = player.getNetWorth();
        player.getPiece().setLocation(new IncomeTaxSquare("It"));
        player.getPiece().getLocation().landedOn(player);

        assertEquals(cash - IncomeTaxSquare.MAXTAX, player.getNetWorth());
    }

    @Test
    public void IncomeTaxIs10PercentOfPlayerWorthWhenPlayer10PercentWorthIsLessThan200() {
        Player player = new Player("test", new Board());

        player.reduceCash(player.getNetWorth() > 0 ? player.getNetWorth() : 0);
        player.addCash(300);
        int cash = player.getNetWorth();
        player.getPiece().setLocation(new IncomeTaxSquare("It"));
        player.getPiece().getLocation().landedOn(player);

        assertEquals(cash - IncomeTaxSquare.TAXPERCENT * cash, player.getNetWorth());
    }
}
