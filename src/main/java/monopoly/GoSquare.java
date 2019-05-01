package monopoly;

public class GoSquare extends Square {
    public GoSquare(String name) {
        super(name);
    }

    @Override
    public void landedOn(Player p) {
        p.addCash(200);
    }
}
