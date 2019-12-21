import java.util.ArrayList;

/**
 * Interface for a reaction card
 */
public interface CardActionReaction {
    /**
     *
     * @param players affected by
     * @param action that the reaction has
     */
    void reaction(ArrayList<Player> players, CardAction action);
}
