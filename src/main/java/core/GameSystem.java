package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Game System holds essential functionality to Dominion game
 */
public class GameSystem {
    private static final int NUM_PLAYERS = 2;
    private static final int STARTING_COPPER = 7;
    private static final int STARTING_ESTATE = 3;

    private ArrayList<CardName> kingdomCardNames;
    private HashMap<CardName, Stack<Card>> gameCards;
    private ArrayList<Card> trash;
    private LinkedList<Player> players;
    private Player currentPlayer;
    private GameListeners listeners;

    /**
     * Constructor for Core.GameSystem
     * @param kingdomCardNames being used for the game
     */
    public GameSystem(ArrayList<CardName> kingdomCardNames){
        listeners = new GameListeners();
        initializeGame(kingdomCardNames);
    }


    private void initializeGame(ArrayList<CardName> kingdomCardNames){
        this.kingdomCardNames = kingdomCardNames;
        gameCards = new HashMap<>();
        ArrayList<Stack<Card>> basicCards = (ArrayList<Stack<Card>>) BasicCardInitialization.generateStartingCards();
        for(Stack<Card> s: basicCards) gameCards.put(s.peek().getName(), s);
        KingdomCardInitialization kingdomCardInitialization= new KingdomCardInitialization();
        for(CardName name: this.kingdomCardNames) {
            Stack<Card> s = kingdomCardInitialization.chooseCards(name);
            gameCards.put(name, s);
        }
        trash = new ArrayList<>();
        players = new LinkedList<>();
        initializePlayers();
    }

    private void initializePlayers() {
        for(int i = 0; i < NUM_PLAYERS; i++){
            players.add(new Player());
        }
        for(Player p: players){
            giveInitialCards(p);
        }
        currentPlayer = players.pollFirst();
        players.add(currentPlayer);
    }

    private void giveInitialCards(Player p) {
        Stack<Card> copper = gameCards.get(CardName.COPPER);
        for(int i = 0; i < STARTING_COPPER; i++) {
            p.gain(copper.pop());
        }

        Stack<Card> estate = gameCards.get(CardName.ESTATE);
        for(int i = 0; i < STARTING_ESTATE; i++) {
            p.gain(estate.pop());
        }
    }

    /**
     * Accessor for cards in game
     * @return cards in game
     */
    public HashMap<CardName, Stack<Card>> getGameCards() {
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

    /**
     *
     * @return names of kingdom cards as enum
     */
    public ArrayList<CardName> getKingdomCardNames() {
        return kingdomCardNames;
    }
}
