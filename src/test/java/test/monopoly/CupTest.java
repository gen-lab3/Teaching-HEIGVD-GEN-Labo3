package test.monopoly;

import monopoly.Cup;
import monopoly.Die;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CupTest {
    private static int DICE_NB = 2;
    private static Cup cup = new Cup(DICE_NB);
    private static Die die = new Die();

    private static int CUP_MAX_VALUE = die.MAX_VALUE * DICE_NB;
    private static int CUP_MIN_VALUE = die.MIN_VALUE *DICE_NB;


    @ParameterizedTest
    @ValueSource(ints = {0, 2, 10})
    public void correctNumberOfDiceCreated(int nb){
        Cup cupTest = new Cup(nb);

        assertEquals(nb, cupTest.numberOfDice());
    }

    @RepeatedTest(50)
    public void cupNumbersAreInCorrectRange(){
        cup.roll();

        int sum = cup.getTotal();

        assertTrue(sum <= (CUP_MAX_VALUE));
        assertTrue(sum >= (CUP_MIN_VALUE));
    }

    @Test
    public void allRangeFoundInCup(){
        Integer[] expected = new Integer[CUP_MAX_VALUE - CUP_MIN_VALUE + 1];

        for(int i = CUP_MIN_VALUE; i <= CUP_MAX_VALUE; ++i){
            expected[i - CUP_MIN_VALUE] = i;
        }

        Set<Integer> actualValues = new HashSet<>();

        for(int j = 0; j < expected.length *20; ++j){
            cup.roll();
            actualValues.add(cup.getTotal());
        }

        Integer[] actual = new Integer[actualValues.size()];
        actualValues.toArray(actual);

        assertArrayEquals(expected, actual);

    }

}
