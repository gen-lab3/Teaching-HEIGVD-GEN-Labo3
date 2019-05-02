package monopoly;

import java.util.ArrayList;
import java.util.List;

public class Cup {
    private List<Die> dice = new ArrayList<>();

    public Cup(int diceNb){

        for(int i = 0; i < diceNb; ++i){
          dice.add(i, new Die());
        }
    }

    public void roll(){
        for(Die die : dice){
            die.roll();
        }
    }

    public int getTotal(){
        int sum = 0;

        for(Die die : dice){
            sum += die.getFaceValue();
        }
        return sum;
    }

    public int numberOfDice(){
        return dice.size();
    }

    public String toString(){
        String diceValues = "";
        for(Die die : dice){
            diceValues += " " + die.getFaceValue();
        }

        return diceValues;
    }
}
