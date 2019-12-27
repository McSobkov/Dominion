package core;

import java.util.ArrayList;

public class GameListeners {
    private final ArrayList<ChangeListener> listeners;

    public GameListeners() {
        listeners = new ArrayList<>();
    }

    public ArrayList<ChangeListener> getListeners() {
        return listeners;
    }

    public void addListener(ChangeListener newListener) {
        listeners.add(newListener);
    }
}
