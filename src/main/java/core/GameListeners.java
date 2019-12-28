package core;

import java.util.ArrayList;

/**
 * Game Listeners hold all change listeners for the game
 */
public class GameListeners {
    private final ArrayList<ChangeListener> listeners;

    /**
     * Constructor for Game Listeners
     */
    public GameListeners() {
        listeners = new ArrayList<>();
    }

    /**
     * Mutator method for Game Listeners
     * @param newListener being added for the game
     */
    public void addListener(ChangeListener newListener) {
        listeners.add(newListener);
    }
}
