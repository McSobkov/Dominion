import java.util.ArrayList;

/**
 * Action that deals with a singular card
 */
public interface CardActionSingleCard extends CardAction{

    /**
     * @param card being interacted with
     * @param currentPlayer taking their turn
     */
    void invokeAction(Card card, Player currentPlayer);
}
