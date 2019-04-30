package test.monopoly;

import monopoly.Die;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DieTest {

    private Die die = new Die();

    @RepeatedTest(50) public void
    numbersAreInRange(){
        int value = die.getFaceValue();

        assertTrue(value <= die.MAX_VALUE);
        assertTrue(value >= die.MIN_VALUE);

        die.roll();
    }
}
