package monopoly;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

public class Monopoly {

    private static final int NB_ROUNDS = 20;
    private static final int NB_DICE = 2;

    private int playerCount = 2;

    private Die[] dice;
    private Board board;
    private Player[] players;

    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("Missing player count argument.");
            return;
        }

        Monopoly monopoly = new Monopoly(Integer.parseInt(args[0]));

        monopoly.playGame();
    }

    public Monopoly(int playerCount){
        this.playerCount = playerCount;
    }

    private void initGame(){
        board = new Board();
        dice = new Die[NB_DICE];
        players = new Player[playerCount];

        for (int i = 0; i < NB_DICE; i++){
            dice[i] = new Die();
        }

        for (int i = 0; i < playerCount; i++){
            players[i] = new Player("Player " + i, board);
        }
    }

    public void playGame(){
        initGame();

        System.out.println("Game starts");

        for (int i = 0; i < NB_ROUNDS; i++){
            System.out.println("--- Round " + (i + 1) + " ---");
            round();
        }
    }

    private void round(){
        for(Player player: players){
            player.takeTurn(dice);
        }
    }
}
