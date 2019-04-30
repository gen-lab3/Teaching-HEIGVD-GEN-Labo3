package test.monopoly.mock;

import monopoly.Die;

public class MockDie extends Die {

    int currentValue = 0;
    int[] values;

    public MockDie(int... values) {

        this.values = values;
    }

    public void roll(){
        currentValue++;
    }

    @Override
    public int getFaceValue() {
        return values[currentValue % values.length];
    }
}
