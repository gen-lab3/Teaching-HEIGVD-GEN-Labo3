package monopoly;

import java.util.ArrayList;

public class Board {
    public static final int BOARD_SIZE = 40;

    public static final String START_NAME = "Go";
    public static final String REGULAR_NAME = "Square";
    public static final String INCOMETAX_NAME = "Income tax";
    public static final String GOTOJAIL_NAME = "Go to jail";

    public static final Square JAIL = new RegularSquare("Jail");

    private ArrayList<Square> squares = new ArrayList<>();

    public Board() {
        squares.add(new GoSquare(START_NAME));

        for(int i = 1; i < BOARD_SIZE; ++i) {
            switch (i) {
                case 30:
                    squares.add(new GoToJailSquare(GOTOJAIL_NAME, JAIL));
                    break;

                case 20:
                    squares.add(new IncomeTaxSquare(INCOMETAX_NAME));
                    break;

                case 10:
                    squares.add(JAIL);
                    break;

                default:
                    squares.add(new RegularSquare(REGULAR_NAME + i));
            }
        }


    }

    public Square getSquare(Square oldLocation, int faceValueTotal) {
        return squares.get((squares.indexOf(oldLocation) + faceValueTotal) % BOARD_SIZE);
    }

    public Square getStartSquare() {
        return squares.get(0);
    }
}
