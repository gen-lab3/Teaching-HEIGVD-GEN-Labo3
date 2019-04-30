import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void APlayerShouldHaveAName(){
        String name = "John";
        Player player = new Player(name, null);
        assertEquals(player.getName(), name);
    }

    @Test
    public void APlayerShouldHaveAPiece(){
        String pieceName = "T-Rex";
        Piece tRex = new Piece(pieceName);
        Player player = new Player(null, tRex);

        assertEquals(tRex, player.getPiece());
    }
}
