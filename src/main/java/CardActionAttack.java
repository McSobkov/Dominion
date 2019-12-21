import java.util.ArrayList;

/**
 * Interface for an attack card
 */
public interface CardActionAttack {
    /**
     *
     * @param players affected by attack
     * @param action triggered on player
     */
    void reaction(ArrayList<Player> players, CardAction action);
}