package gui;

import core.CardName;
import core.ChangeListener;
import core.GameSystem;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

/**
 * Main Panel for Dominion GUI
 */
public class DominionPanel extends JPanel implements ChangeListener {
    private GameSystem game;
    private HashMap<CardName, BufferedImage> cardImages;

    /**
     * Constructor for Dominion Panel
     * @param game being used with GUI
     * @throws IOException file not found
     */
    public DominionPanel(GameSystem game) throws IOException {
        this.game = game;
        cardImages = new CardImages().getImage();
        JPanel supplyPanel = new SupplyPanel(this, game);
        this.add(supplyPanel);
    }

        BufferedImage getImage(CardName name) {
            BufferedImage img = cardImages.get(name);
            assert(img != null);
            return img;
        }


}
