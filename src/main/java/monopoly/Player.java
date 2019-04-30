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

        for (Die die : dice) {
            die.roll();
            facesValue += die.getFaceValue();
        }

        Square oldLocation = piece.getLocation();
        Square newLocation = board.getSquare(oldLocation, facesValue);
        piece.setLocation(newLocation);
    }
}
