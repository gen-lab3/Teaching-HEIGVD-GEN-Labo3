package monopoly;

public class GoSquare extends Square {
    public static final int STARTCASH = 200;

    public GoSquare(String name) {
        super(name);
    }

    @Override
    public void landedOn(Player p) {
        p.addCash(STARTCASH);
    }
}
