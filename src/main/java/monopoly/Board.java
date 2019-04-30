package monopoly;

import java.util.ArrayList;

public class Board {
    public static final int BOARD_SIZE = 40;
    public static final String START_NAME = "Go";
    private ArrayList<Square> squares = new ArrayList<>();

    public Board() {
        squares.add(new Square(START_NAME));

        for(int i = 1; i < BOARD_SIZE; ++i) {
            squares.add(new Square("monopoly.Square" + i));
        }
    }

    public Square getSquare(Square oldLocation, int faceValueTotal) {
        return squares.get((squares.indexOf(oldLocation) + faceValueTotal) % BOARD_SIZE);
    }

    public Square getStartSquare() {
        return squares.get(0);
    }
}
