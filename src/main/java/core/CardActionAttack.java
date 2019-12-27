package core;

import java.util.ArrayList;

/**
 * Interface for an attack card
 */
public interface CardActionAttack extends CardAction{
    /**
     *
     * @param players affected by attack
     * @param action triggered on player
     */
    void attack(ArrayList<Player> players, CardAction action);

    /**
     * Attacks can have an action that affects the player
     * playing it as well. This action goes here.
     * @param currentPlayer taking their turn
     */
    void invokeAction(Player currentPlayer);
}