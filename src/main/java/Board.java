import java.util.ArrayList;

public class Board {
    private static final int BOARD_SIZE = 40;
    private ArrayList<Square> squares = new ArrayList<>();

    public Board() {
        squares.add(new Square("Go"));

        for(int i = 1; i < BOARD_SIZE; ++i) {
            squares.add(new Square("Square" + i));
        }
    }

    public Square getSquare(Square oldLocation, int faceValueTotal) {
        return squares.get((squares.indexOf(oldLocation) + faceValueTotal) % BOARD_SIZE);
    }

    public Square getStartSquare() {
        return squares.get(0);
    }
}
