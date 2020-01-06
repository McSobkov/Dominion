package core;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Representation for a turn that a player is taking
 */
public class Turn {

    private ArrayList<Card> actionCardsPlayed;
    private Player player;
    private int actionsRemaining;
    private int buysRemaining;
    private int goldForBuy;
    private GameSystem game;

    /**
     * Constructor for turn
     * @param game of Dominion being played
     */
    public Turn(GameSystem game) {
        actionCardsPlayed = new ArrayList<>();
        player = game.getCurrentPlayer();
        player.setTurn();
        actionsRemaining = 1;
        buysRemaining = 1;
        goldForBuy = 0;
        this.game = game;
    }

    /**
     * Function to play an action card on a player's turn
     * @param card that's action is being activated
     */
    public void playActionCard(Card card) {
        assert (actionsRemaining > 0);
        actionsRemaining += card.getAction();
        buysRemaining += card.getBuy();
        goldForBuy += card.getGold();
        player.drawCards(card.getDraw());

        CardAction action = card.getCardAction();
        if (action instanceof CardActionSimple) {
            ((CardActionSimple) action).invokeAction(player);
        }
        else if (action instanceof CardActionAffectAll) {
            CardActionAffectAll actionAffectAll = (CardActionAffectAll) action;
            actionAffectAll.invokeAction(player);
            LinkedList<Player> playersAffected = game.getPlayers();
            actionAffectAll.affectAll(playersAffected);
        }
        //Rest of interfaces
    }

    /**
     * @return number of actions remaining
     */
    public int getActionsRemaining() {
        return actionsRemaining;
    }

    /**
     * @return number of buys remaining
     */
    public int getBuysRemaining() {
        return buysRemaining;
    }


    public boolean take() {
        player.drawCards(5);
        for(Card c: player.getHand()) game.callDrawListener(c);


        player.setTurn();
        return false;
    }
}
