package monopoly;

public class GoToJailSquare extends Square {
    private Square jail;

    public GoToJailSquare(String name, Square jail) {
        super(name);

        this.jail = jail;
    }

    @Override
    public void landedOn(Player p) {
        p.getPiece().setLocation(jail);
    }
}
