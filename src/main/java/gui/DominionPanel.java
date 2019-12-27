package gui;

import core.ChangeListener;
import core.GameSystem;

import javax.swing.JPanel;

/**
 * Main Panel for Dominion GUI
 */
public class DominionPanel extends JPanel implements ChangeListener {
    private GameSystem game;

    /**
     * Constructor for Dominion Panel
     * @param game being used with GUI
     */
    public DominionPanel(GameSystem game) {
        this.game = game;
    }


}
