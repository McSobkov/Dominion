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


    /**
     * Main method
     * @param args none parsed
     * @throws IOException card image not found
     * @throws InterruptedException dont worry about it :)
     */

    public static void main(String[] args) throws IOException, InterruptedException {


        JFrame frame = new JFrame("Card Selection");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KingdomCardSelectionPanel kingdomCardSelectionPanel = new KingdomCardSelectionPanel(frame);
        kingdomCardSelectionPanel.setOpaque(true);
        frame.setContentPane(kingdomCardSelectionPanel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.pack();
        frame.setVisible(true);

        boolean selectionDone = false;
        while(!selectionDone){
            selectionDone = !frame.isVisible();
            //TODO proper means to remove race condition
            System.out.println();
        }




        ArrayList<CardName> kingdomCards = kingdomCardSelectionPanel.getCardName();
        frame.dispose();



        JFrame gameFrame = new JFrame("Dominion");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        core.GameSystem game = new core.GameSystem(kingdomCards);

        // Create and set up the content pane.
        DominionPanel dominionPanel = new DominionPanel(game);
        dominionPanel.setOpaque(true);
        game.addListener(dominionPanel);
        gameFrame.setContentPane(dominionPanel);

        gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        // Display the window.
        gameFrame.pack();
        gameFrame.setVisible(true);
        game.start();
    }

  




}

