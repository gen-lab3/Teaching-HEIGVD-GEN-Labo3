package monopoly;

import java.util.List;

public class Cup {
    private List<Die> dice;

    public Cup(List<Die> dice){
        this.dice = dice;
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
}
