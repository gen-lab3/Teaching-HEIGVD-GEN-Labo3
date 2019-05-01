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
        for(Die d : dice){
            d.roll();
        }
    }

    public int getTotal(){
        int sum = 0;

        for(Die d : dice){
            sum += d.getFaceValue();
        }
        return sum;
    }

    public int numberOfDice(){
        return dice.size();
    }
}
