package gui;

import core.Card;
import core.CardName;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;


public class CurrentPlayerArea extends JPanel {
    private HashMap<CardName, BufferedImage> images;
    private ArrayList<JButton> hand;


    public CurrentPlayerArea(HashMap<CardName, BufferedImage> images) {
        this.images = images;
        hand = new ArrayList<>();
        //this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));


    }

    public void draw(Card c) {
        ImageIcon icon = new ImageIcon(images.get(c.getName()));
        JButton button = new JButton();
        button.setIcon(icon);
        //this.add(button);
        hand.add(button);

    }

    ArrayList<JButton> getHand() {
        return hand;
    }

}
