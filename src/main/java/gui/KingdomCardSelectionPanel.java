package gui;

import core.CardName;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * First panel seen where the cards for the game are chosen.
 */
public class KingdomCardSelectionPanel extends JPanel {
    private CardImages images;
    private ArrayList<CardName> chosenCards;

    public KingdomCardSelectionPanel() throws IOException {
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
                }
                else{
                    chosenCards.remove(c);
                    button.setVisible(true);
                }
            });
            BufferedImage img = images.getImage().get(c);
            BufferedImage scaledImg = new BufferedImage(
                    3*img.getWidth()/4,
                    3*img.getHeight()/4,
                    img.getType());
            AffineTransform at = AffineTransform.getScaleInstance(.75,.75);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            op.filter(img, scaledImg);
            button.setIcon(new ImageIcon(scaledImg));
            this.add(button);
        }
    }
}
