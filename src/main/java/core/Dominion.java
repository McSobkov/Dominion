package core;

import gui.DominionPanel;
import gui.KingdomCardSelectionPanel;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Main game
 */

public class Dominion {
    private ArrayList<CardName> kingdomCards;

    /**
     * Main method
     * @param args none parsed
     */
    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowCardSelection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void createAndShowCardSelection() throws IOException {
        JFrame frame = new JFrame("Card Selection");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KingdomCardSelectionPanel kingdomCardSelectionPanel = new KingdomCardSelectionPanel();
        kingdomCardSelectionPanel.setOpaque(true);
        frame.setContentPane(kingdomCardSelectionPanel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.pack();
        frame.setVisible(true);
    }


    private static void createAndShowGame() throws IOException {
        // Create and set-up the window.
        JFrame frame = new JFrame("Dominion");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ArrayList<String> cards = new ArrayList<>();
        cards.add("Festival");
        cards.add("Village");
        cards.add("Library");
        cards.add("Market");
        cards.add("Merchant");
        cards.add("Militia");
        cards.add("Mine");
        cards.add("Moat");
        cards.add("Moneylender");
        cards.add("Smithy");

        //TODO pass actual kingdomcards or refactor Core.GameSystem
        core.GameSystem game = new core.GameSystem(cards);

        // Create and set up the content pane.
        DominionPanel dominionPanel = new DominionPanel(game);
        dominionPanel.setOpaque(true);
        game.addListener(dominionPanel);
        frame.setContentPane(dominionPanel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        // Display the window.
        frame.pack();
        frame.setVisible(false);

    }
}

