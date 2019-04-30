package monopoly;

import java.util.Random;

public class Die {
    public final int MAX_VALUE = 6;
    public final int MIN_VALUE = 1;

    private static Random random = new Random();

    private int faceValue;

    public Die() {
        roll();
    }

    public void roll(){
        int randValue = Math.abs(random.nextInt());
        int nbValues = MAX_VALUE - MIN_VALUE + 1;

        faceValue = (randValue % nbValues) + MIN_VALUE;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
