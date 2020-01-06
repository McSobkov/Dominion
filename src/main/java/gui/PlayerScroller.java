package gui;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerScroller extends JScrollPane {

    PlayerScroller(CurrentPlayerArea playerArea) {
        super(playerArea);
        JPanel view = new JPanel();
        ArrayList<JButton> hand = playerArea.getHand();
        //view.setLayout(new GridLayout(1, hand.size()));

        for (JButton jButton : hand) {
            jButton.setBorder(null);
            view.add(jButton);
        }

        super.setViewportView(view);
        //super.horizontalScrollBarPolicy = HORIZONTAL_SCROLLBAR_ALWAYS;
    }

    JScrollPane getScroller() {
        return this;
    }

}
