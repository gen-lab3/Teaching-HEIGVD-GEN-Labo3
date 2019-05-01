package monopoly;

import static java.lang.Integer.min;
import static java.lang.Math.round;

public class IncomeTaxSquare extends Square {
    public IncomeTaxSquare(String name) {
        super(name);
    }

    @Override
    public void landedOn(Player p) {
        int w = p.getNetWorth();
        p.reduceCash(min(200, (int) round(0.1 * w)));
    }
}
