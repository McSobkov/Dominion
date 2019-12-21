/**
 * Interface for an action card
 */
public interface CardAction {

    /**
     * Action the card takes
     * @param p current player turn
     */
    void action(Player p);
}
