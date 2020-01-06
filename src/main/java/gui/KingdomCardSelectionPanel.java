package gui;

import core.CardName;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * First panel seen where the cards for the game are chosen.
 */
public class KingdomCardSelectionPanel extends JPanel {
    private CardImages images;
    private ArrayList<CardName> chosenCards;

    /**
     * Constructor for card selection panel
     * @throws IOException cards not found
     * @param frame being used
     */
    public KingdomCardSelectionPanel(JFrame frame) throws IOException {
        this.setLayout(new FlowLayout());
        chosenCards = new ArrayList<>();


        HashSet<CardName> baseCardNames = new HashSet<>();
        baseCardNames.add(CardName.COPPER);
        baseCardNames.add(CardName.SILVER);
        baseCardNames.add(CardName.GOLD);
        baseCardNames.add(CardName.ESTATE);
        baseCardNames.add(CardName.DUCHY);
        baseCardNames.add(CardName.PROVINCE);
        baseCardNames.add(CardName.CURSE);

        images = new CardImages();
        Set allCardNamesSet = images.getImage().keySet();
        allCardNamesSet.removeAll(baseCardNames);
        for (Object c: allCardNamesSet) {
            assert (c instanceof CardName);
            JButton button = new JButton();
            button.setBorder(null);
            button.addActionListener(e -> {
                if(chosenCards.indexOf(c) == -1) {
                    chosenCards.add((CardName) c);
                    button.setVisible(false);
                    if (chosenCards.size() == 10) frame.setVisible(false);
                }
                else{
                    chosenCards.remove(c);
                    button.setVisible(true);
                }
            });
            BufferedImage img = images.getImage().get(c);
            //BufferedImage scaledImg = CardImages.scaleDownImage(img);
            button.setIcon(new ImageIcon(img));
            this.add(button);
        }
    }


    /**
     *
     * @return a
     */
    public ArrayList<CardName> getCardName() {
        return chosenCards;
    }
}
