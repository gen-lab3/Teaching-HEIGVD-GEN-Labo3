package monopoly;

public class IncomeTaxSquare extends Square {
    public IncomeTaxSquare(String name) {
        super(name);
    }

    @Override
    public void landedOn(Player p) {
        // Manage tax
    }
}
