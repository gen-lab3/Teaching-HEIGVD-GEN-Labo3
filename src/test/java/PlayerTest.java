import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void APlayerShouldHaveAName(){
        String name = "John";
        Player player = new Player(name);
        assertEquals(player.getName(), name);
    }
}
