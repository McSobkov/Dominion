import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Main game
 */

public class Dominion {
    private static final int NUM_PLAYERS = 2;
    private static final int STARTING_COPPER = 7;
    private static final int STARTING_ESTATE = 3;



    private ArrayList<Card> gameCards;
    private ArrayList<Card> trash;
    private Queue<Player> players;
    private Player currentPlayer;

    /**
     * Initializes Game
     * @param kingdomCardNames in game
     */
    public void initializeGame(ArrayList<String> kingdomCardNames){
        //TODO gamecards needs to be done properly
        gameCards = new ArrayList<>(BasicCardInitialization.generateStartingCards());
        gameCards.addAll(KingdomCardInitialization.chooseCards(kingdomCardNames));
        trash = new ArrayList<>();
        players = new LinkedList<>();
        initializePlayers();
    }

    private void initializePlayers() {
        for(int i = 0; i < NUM_PLAYERS; i++){
            players.add(new Player());
        }
        //TODO gain actual cards
        for(Player p: players){
            p.gain(gameCards.get(0));
            p.gain(gameCards.get(0));
        }
    }

    /**
     *
     * @return cards in game
     */
    public ArrayList<Card> getGameCards() {
        return gameCards;
    }

    /**
     * Main method
     * @param args none parsed
     */
    public static void main(String[] args) {
        Dominion game = new Dominion();
        ArrayList<String> kingdomCards = new ArrayList<>();
        kingdomCards.add("Village");
        game.initializeGame(kingdomCards);
    }
}
