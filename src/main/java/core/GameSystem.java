package core;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Game System holds essential functionality to Dominion game
 */
public class GameSystem {
    private static final int NUM_PLAYERS = 2;
    private static final int STARTING_COPPER = 7;
    private static final int STARTING_ESTATE = 3;



    private ArrayList<Card> gameCards;
    private ArrayList<Card> trash;
    private LinkedList<Player> players;
    private Player currentPlayer;
    private GameListeners listeners;

    /**
     * Constructor for Core.GameSystem
     * @param kingdomCardNames being used for the game
     */
    public GameSystem(ArrayList<String> kingdomCardNames){
        listeners = new GameListeners();
        initializeGame(kingdomCardNames);
    }




    /**
     * Initializes Game
     * @param kingdomCardNames in game
     */
    public void initializeGame(ArrayList<String> kingdomCardNames){
        //TODO gamecards needs to be done properly
        gameCards = new ArrayList<>(BasicCardInitialization.generateStartingCards());
        gameCards.addAll(new KingdomCardInitialization().chooseCards(kingdomCardNames));
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
     * Accessor for cards in game
     * @return cards in game
     */
    public ArrayList<Card> getGameCards() {
        return gameCards;
    }

    /**
     * Accessor for players
     * @return players in game
     */
    public LinkedList<Player> getPlayers() {
        return players;
    }

    /**
     * Mutator to add new listener to game
     * @param newListener being added to game
     */
    public void addListener(ChangeListener newListener) {
        listeners.addListener(newListener);
    }

    /**
     * Accessor for current player
     * @return player taking their turn
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
