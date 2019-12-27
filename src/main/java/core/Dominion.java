package core;

import gui.DominionPanel;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Main game
 */

public class Dominion {


    /**
     * Main method
     * @param args none parsed
     */
    public static void main(String[] args) {
        /*ArrayList<String> kingdomCards = new ArrayList<>();
        game.initializeGame(kingdomCards);*/

        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void createAndShowGame() throws IOException {
        // Create and set-up the window.
        JFrame frame = new JFrame("Core.Dominion");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //TODO pass actual kingdomcards or refactor Core.GameSystem
        GameSystem game = new GameSystem(new ArrayList<>());

        // Create and set up the content pane.
        DominionPanel dominionPanel = new DominionPanel(game);
        dominionPanel.setOpaque(true);
        game.addListener(dominionPanel);
       frame.setContentPane(dominionPanel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        // Display the window.
        frame.pack();
        frame.setVisible(true);

    }
}
