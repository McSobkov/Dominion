import java.util.ArrayList;

/**
 * Card action distinct from attack as a positive
 * action is taken on all players.
 */
public interface CardActionAffectAll extends CardAction{
    /**
     * Action that affects all players
     * @param players in game (be sure to remove current player if necessary
     */
    void affectAll(ArrayList<Player> players);

    /**
     *
     * @param currentPlayer taking their turn
     */
    void invokeAction(Player currentPlayer);
}
