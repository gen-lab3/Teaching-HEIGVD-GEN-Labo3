package monopoly;

public class Monopoly {

    private static final int NB_ROUNDS = 20;
    private static final int NB_DICE = 2;

    private int playerCount = 2;

    private Cup cup;
    private Board board;
    private Player[] players;

    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("Missing player count argument.");
            return;
        }

        try{
            int nbPlayers = Integer.parseInt(args[0]);

            if(nbPlayers < 2 || nbPlayers > 8){
                System.err.println("You can play only from 2 to 8 players");
                return;
            }


            Monopoly monopoly = new Monopoly(nbPlayers);

            monopoly.playGame();
        } catch (NumberFormatException e){
            System.err.println("The first param must be a number");
        }

    }

    public Monopoly(int playerCount){
        this.playerCount = playerCount;
    }

    private void initGame(){
        board = new Board();
        cup = new Cup(NB_DICE);
        players = new Player[playerCount];

        for (int i = 0; i < playerCount; i++){
            players[i] = new Player("Player " + i, board);
            players[i].addCash(1500);
        }
    }

    public void playGame(){
        initGame();

        System.out.println("\nGAME STARTS!\n");

        for (int i = 0; i < NB_ROUNDS; i++){
            System.out.println("--- Round " + (i + 1) + " ---");
            round();
        }
    }

    private void round(){
        for(Player player: players){
            player.takeTurn(cup);
        }
    }
}
