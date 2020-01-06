package core;

/**
 * Interface for what a change listener should have
 */
public interface ChangeListener {
    /**
     * Called when a card is drawn in the game
     * @param c card being drawn
     */
    void drawCard(Card c);

}
