package gui;

import core.Card;
import core.CardName;
import core.ChangeListener;
import core.GameSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

/**
 * Main Panel for Dominion GUI
 */
public class DominionPanel extends JPanel implements ChangeListener {
    private GameSystem game;
    private HashMap<CardName, BufferedImage> cardImages;

    private CurrentPlayerArea playerArea;
    private PlayerScroller playerScroller;

    /**
     * Constructor for Dominion Panel
     * @param game being used with GUI
     * @throws IOException file not found
     */
    public DominionPanel(GameSystem game) throws IOException {
        this.game = game;
        cardImages = new CardImages().getImage();


        setLayout(new BorderLayout());
        add(new SupplyPanel(cardImages, game), BorderLayout.NORTH);

        playerArea = new CurrentPlayerArea(cardImages);
        playerScroller = new PlayerScroller(playerArea);
        this.add(playerScroller, BorderLayout.SOUTH);
    }

        BufferedImage getImage(CardName name) {
            BufferedImage img = cardImages.get(name);
            assert(img != null);
            return img;
        }


    private void updatePlayerArea() {
        this.remove(playerScroller);
        playerScroller = new PlayerScroller(playerArea);
        this.add(playerScroller, BorderLayout.SOUTH);
    }

    @Override
    public void drawCard(Card c) {
        playerArea.draw(c);
        updatePlayerArea();
    }

    HashMap<CardName, BufferedImage> getCardImages() {
        return cardImages;
    }
}
