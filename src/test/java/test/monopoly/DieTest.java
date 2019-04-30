package test.monopoly;

import monopoly.Die;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DieTest {

    private static Die die = new Die();

    @RepeatedTest(50)
    public void numbersAreInRange(){
        int value = die.getFaceValue();

        assertTrue(value <= die.MAX_VALUE);
        assertTrue(value >= die.MIN_VALUE);



        die.roll();
    }

    @Test
    public void allRangeFound(){
        Integer[] expected = new Integer[die.MAX_VALUE - die.MIN_VALUE + 1];

        for(int i = die.MIN_VALUE; i <= die.MAX_VALUE; i++){
            expected[i - die.MIN_VALUE] = i;
        }


        Set<Integer> foundValues = new HashSet<>();

        for(int i = 0; i < expected.length * 20; i++){
            die.roll();
            foundValues.add(die.getFaceValue());
        }

        Integer[] values = new Integer[foundValues.size()];
        foundValues.toArray(values);

        assertArrayEquals(expected, values);
    }


}
