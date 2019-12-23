/**
 * Card action that has nothing special
 */
public interface CardActionSimple extends  CardAction{
    /**
     * Action called
     * @param currentPlayer taking their turn
     */
    void invokeAction(Player currentPlayer);
}
