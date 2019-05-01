package monopoly;

import static java.lang.Integer.min;
import static java.lang.Math.round;

public class IncomeTaxSquare extends Square {
    public static final double TAXPERCENT = 0.1;
    public static final int MAXTAX = 200;

    public IncomeTaxSquare(String name) {
        super(name);
    }

    @Override
    public void landedOn(Player p) {
        int w = p.getNetWorth();
        p.reduceCash(min(MAXTAX, (int) round(TAXPERCENT * w)));
    }
}
