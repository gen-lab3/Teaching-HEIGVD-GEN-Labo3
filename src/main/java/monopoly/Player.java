package monopoly;

public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private int cash = 0;

    public Player(String name, Board board){
        this.name = name;
        this.board = board;

        this.piece = new Piece("Piece de " + name);
        this.piece.setLocation(board.getStartSquare());
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void takeTurn(Cup cup) {

        cup.roll();
        int facesValue = cup.getTotal();

        System.out.printf("%s throw dice, got: %s", name, cup);

        Square oldLocation = piece.getLocation();

        Square newLocation = board.getSquare(oldLocation, facesValue);

        piece.setLocation(newLocation);
        newLocation.landedOn(this);

        System.out.printf("\n%s landed on %s\n\n", name, newLocation);
    }

    public void addCash(int cash){
        this.cash += cash;
    }

    public void reduceCash(int amount){
        if(cash - amount < 0){
            cash = 0;
        }else{
            cash -= amount;
        }
    }

    public int getNetWorth(){
        return cash;
    }
}
