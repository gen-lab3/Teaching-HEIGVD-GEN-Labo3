import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

public class Monopoly {

    private ArrayList<Die> dice;
    private Board board;
    private ArrayList<Player> players;

    public static void main(String[] args) {
        new Monopoly();
    }

    public Monopoly(){
        dice = new ArrayList<>();
        players = new ArrayList<>();

        dice.add(new Die());
        dice.add(new Die());


    }
}
