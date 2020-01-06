package gui;

import core.CardName;
import core.GameSystem;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.Box;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Display for the supply
 */
public class SupplyPanel extends JPanel {
    private static final int KINGDOM_ROWS = 2;
    private static final int KINGDOM_COLS = 5;

    private GameSystem gameSystem;

    private JPanel treasury;
    private JPanel kingdom;
    private JPanel victory;
    private HashMap<CardName, BufferedImage> images;
    private JButton[][] kingdomSpots;

    /**
     * Constructor for the display for the supply
     * @param images images used in the game
     * @param gameSystem the instance of the game being played
     */
    public SupplyPanel(HashMap<CardName, BufferedImage> images,
                       GameSystem gameSystem) {
        this.setLayout(new FlowLayout());
        this.images = images;
        this.gameSystem = gameSystem;


        setupTreasury();
        setupKingdom();
        setupVictory();


        this.add(treasury);
        this.add(kingdom);
        this.add(victory);
    }

    private void setupVictory() {
        victory = new JPanel();
        victory.setLayout(new BoxLayout(victory, BoxLayout.Y_AXIS));

        JButton estate = new JButton();
        JButton duchy = new JButton();
        JButton province = new JButton();


        estate.setBorder(null);
        duchy.setBorder(null);
        province.setBorder(null);


        BufferedImage rotatedEstate = CardImages.rotateClockwise(images.get(CardName.ESTATE), 1);
        BufferedImage rotatedDuchy = CardImages.rotateClockwise(images.get(CardName.DUCHY), 1);
        BufferedImage rotatedProvince = CardImages.rotateClockwise(images.get(CardName.PROVINCE), 1);


        estate.setIcon(new ImageIcon(rotatedEstate));
        duchy.setIcon(new ImageIcon(rotatedDuchy));
        province.setIcon(new ImageIcon(rotatedProvince));


        victory.add(estate);
        victory.add(Box.createRigidArea(new Dimension(0, 5)));
        victory.add(duchy);
        victory.add(Box.createRigidArea(new Dimension(0, 5)));
        victory.add(province);

    }

    private void setupKingdom() {
        kingdom = new JPanel();
        kingdom.setLayout(new GridLayout(KINGDOM_ROWS, KINGDOM_COLS));
        kingdomSpots = new JButton[KINGDOM_ROWS][KINGDOM_COLS];
        ArrayList<CardName> cardNames = gameSystem.getKingdomCardNames();
        int count = 0;
        for(int i = 0; i < KINGDOM_ROWS; i++) {
            for(int j = 0; j < KINGDOM_COLS; j++) {
                kingdomSpots[i][j] = new JButton();
                kingdomSpots[i][j].setBorder(null);
                CardName currentCard = cardNames.get(count);
                count++;
                kingdomSpots[i][j].setIcon(new ImageIcon(images.get(currentCard)));
                kingdom.add(kingdomSpots[i][j]);
            }
        }
    }

    private void setupTreasury() {
        treasury = new JPanel();
        treasury.setLayout(new BoxLayout(treasury, BoxLayout.Y_AXIS));

        JButton gold = new JButton();
        JButton silver = new JButton();
        JButton copper = new JButton();
        JButton curse = new JButton();

        gold.setBorder(null);
        silver.setBorder(null);
        copper.setBorder(null);
        curse.setBorder(null);

        BufferedImage rotatedGold = CardImages.rotateClockwise(images.get(CardName.GOLD), 3);
        BufferedImage rotatedSilver = CardImages.rotateClockwise(images.get(CardName.SILVER), 3);
        BufferedImage rotatedCopper = CardImages.rotateClockwise(images.get(CardName.COPPER), 3);
        BufferedImage rotatedCurse = CardImages.rotateClockwise(images.get(CardName.CURSE), 3);

        gold.setIcon(new ImageIcon(rotatedGold));
        silver.setIcon(new ImageIcon(rotatedSilver));
        copper.setIcon(new ImageIcon(rotatedCopper));
        curse.setIcon(new ImageIcon(rotatedCurse));

        treasury.add(gold);
        treasury.add(Box.createRigidArea(new Dimension(0, 5)));
        treasury.add(silver);
        treasury.add(Box.createRigidArea(new Dimension(0, 5)));
        treasury.add(copper);
        treasury.add(Box.createRigidArea(new Dimension(0, 5)));
        treasury.add(curse);
    }
}
