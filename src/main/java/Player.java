import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * A player of the game
 */
public class Player {
    private Stack<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> discard;

    /**
     * Player of the game
     */
    public Player(){
        deck = new Stack<>();
        hand = new ArrayList<>();
        discard = new ArrayList<>();
    }

    public int getDeckSize() { return deck.size(); }

    /**
     * Rebuilds deck from discard
     */
    public void reshuffle(){
        deck.addAll(discard);
        discard.clear();
        Collections.shuffle(deck);
    }

    /**
     * Draws cards from deck
     * @param draws number of cards added to hand
     */
    public void drawCards(int draws){
        for(int i = 0; i < draws; i++){
            if(deck.empty()) reshuffle();
            hand.add(deck.pop());
        }
    }

    /**
     * Gains card
     * @param card added to player's kingdom
     */
    public void gain(Card card) {
        discard.add(card);
    }

    public int getHandSize() { return hand.size(); }

    /**
     * @return copy of the player's hand
     */
    public ArrayList<Card> getHand(){
        return new ArrayList<>(hand);
    }
}
