package core;

import java.util.ArrayList;
import java.util.LinkedList;

public class Turn {

    private ArrayList<Card> actionCardsPlayed;
    private Player player;
    private int actionsRemaining;
    private int buysRemaining;
    private int goldForBuy;
    private GameSystem game;

    public Turn(GameSystem game) {
        actionCardsPlayed = new ArrayList<>();
        player = game.getCurrentPlayer();
        actionsRemaining = 1;
        buysRemaining = 1;
        goldForBuy = 0;
        this.game = game;
    }

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

    }


    public int getActionsRemaining() {
        return actionsRemaining;
    }

    public int getBuysRemaining() {
        return buysRemaining;
    }


}
