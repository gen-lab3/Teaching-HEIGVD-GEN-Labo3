import java.util.ArrayList;

public class Board {
    private static int SQUARE_NB = 40;
    private ArrayList<Square> squares = new ArrayList<>(SQUARE_NB);

    public Board(){
        for (int i = 0; i < SQUARE_NB; ++i){
            squares.add(i, new Square("case" + i));
        }
    }

    public int getSize(){
        return squares.size();
    }
}
