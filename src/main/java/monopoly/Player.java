package monopoly;

public class Player {
    private String name;
    private Piece piece;
    private Board board;

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

    public void takeTurn(Die ...dice) {
        int facesValue = 0;

        System.out.print(name + " throw dice, got: ");
        for (Die die : dice) {
            die.roll();
            int fv = die.getFaceValue();

            System.out.print(fv + " ");

            facesValue += fv;
        }

        Square oldLocation = piece.getLocation();
        Square newLocation = board.getSquare(oldLocation, facesValue);
        piece.setLocation(newLocation);

        System.out.printf("\n%s landed on %s\n\n", name, newLocation);
    }
}
