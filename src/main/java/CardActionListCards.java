import java.util.ArrayList;

/**
 * Interface for cards that you can "select n cards"
 */
public interface CardActionListCards extends CardAction{
    /**
     *
     * @param selected cards chosen to use from hand
     * @param currentPlayer taking their turn
     */
    void invokeAction(ArrayList<Card> selected, Player currentPlayer);

}
