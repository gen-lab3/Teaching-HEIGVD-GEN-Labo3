package test.monopoly.mock;

import monopoly.Cup;
import monopoly.Die;

public class MockCup extends Cup {

    int[] dice;

    public MockCup(int... values) {
        super(values.length);
        dice = values;
    }

    public int getTotal(){
        int sum = 0;

        for(int die : dice){
            sum += die;
        }
        return sum;
    }

    public String toString(){
        String diceValues = "";
        for(int die : dice){
            diceValues += " " + die;
        }

        return diceValues;
    }
}
