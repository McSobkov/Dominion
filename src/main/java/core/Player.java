package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * A player of the game
 */
public class Player {
    private Stack<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> discard;
    private boolean going;

    /**
     * Core.Player of the game
     */
    public Player(){
        deck = new Stack<>();
        hand = new ArrayList<>();
        discard = new ArrayList<>();
        going = false;
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
            Card drawn = deck.pop();
            hand.add(drawn);

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

    /**
     * Discards a card from the hand
     * @param target card being discarded
     */
    public void discard(Card target) {
        assert(hand.remove(target));
        discard.add(target);
    }

    /**
     * Trashes a specific card
     * @param card being trashed
     */
    public void trash(Card card) {
        assert(hand.remove(card));

    }

    /**
     * Takes a card out of a player's discard pile
     * @param card being removed from discard
     */
    public void removeFromDiscard(Card card) {
        assert(discard.remove(card));
    }

    /**
     * Puts a card onto the player's deck
     * @param card being put on deck
     */
    public void putOnDeck(Card card) {
        deck.push(card);
    }


    public void setTurn() {
        going = !going;
    }

    public void discardAll() {
        for(Card card: hand) discard(card);
    }
}
