package core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Initializes kingdom cards
 */
public final class KingdomCardInitialization {

    private static final int TWO_COST = 2;
    private static final int THREE_COST = 3;
    private static final int FOUR_COST = 4;
    private static final int FIVE_COST = 5;
    private static final int SIX_COST = 6;
    private static final int NUM_PILES = 10;
    private static final int ACTION_COUNT = 10;


    private static final int MAX_CHAPEL_DISCARDS = 4;



    /**
     *
     * @param names of kingdom cards
     * @return list of cards in kingdom
     */
    public List<Card> chooseCards(List<CardName> names){
        //assert(names.size() == NUM_PILES);
        ArrayList<CardName> cardNames = (ArrayList<CardName>) names;
        ArrayList<Card> gameCards = new ArrayList<>();
        for(CardName s: cardNames){

            switch (s){
                default: break;
                case ARTISAN: gameCards.add(buildArtisan()); break;
                case BANDIT: gameCards.add(buildBandit()); break;
                case BUREAUCRAT: gameCards.add(buildBureaucrat()); break;
                case CELLAR: gameCards.add(buildCellar()); break;
                case CHAPEL: gameCards.add(buildChapel()); break;
                case COUNCIL_ROOM: gameCards.add(buildCouncilRoom()); break;
                case GARDENS: gameCards.add(buildGardens()); break;
                case FESTIVAL: gameCards.add(buildFestival()); break;
                case HARBINGER: gameCards.add(buildHarbinger()); break;
                case LABORATORY: gameCards.add(buildLaboratory()); break;
                case LIBRARY: gameCards.add(buildLibrary()); break;
                case MARKET: gameCards.add(buildMarket()); break;
                case MERCHANT: gameCards.add(buildMerchant()); break;
                case MILITIA: gameCards.add(buildMilitia()); break;
                case MINE: gameCards.add(buildMine()); break;
                case MOAT: gameCards.add(buildMoat()); break;
                case MONEYLENDER: gameCards.add(buildMoneylender()); break;
                case POACHER: gameCards.add(buildPoacher()); break;
                case REMODEL: gameCards.add(buildRemodel()); break;
                case SENTRY: gameCards.add(buildSentry()); break;
                case SMITHY: gameCards.add(buildSmithy()); break;
                case THRONE_ROOM: gameCards.add(buildThroneRoom()); break;
                case VASSAL: gameCards.add(buildVassal()); break;
                case VILLAGE: gameCards.add(buildVillage()); break;
                case WITCH: gameCards.add(buildWitch()); break;
                case WORKSHOP: gameCards.add(buildWorkshop()); break;


            }
        }
        return gameCards;
    }


    private Card buildArtisan() {
        return new Card.CardBuilder(CardName.ARTISAN, CardType.KINGDOM, SIX_COST)
                .addCardAction((CardActionSimple) currentPlayer -> {
                    //TODO
                })
                .build();
    }

    private Card buildBandit() {
        return new Card.CardBuilder(CardName.BANDIT, CardType.KINGDOM, FIVE_COST)
                .addCardAction(new CardActionAttack() {
                    @Override
                    public void attack(ArrayList<Player> players, CardAction action) {
                        //TODO
                    }

                    @Override
                    public void invokeAction(Player currentPlayer) {
                        //TODO Gain gold
                    }
                })
                .build();
    }

    private Card buildBureaucrat() {
        return new Card.CardBuilder(CardName.BUREAUCRAT, CardType.KINGDOM, FOUR_COST)
                .addCardAction(new CardActionAttack() {
                    @Override
                    public void attack(ArrayList<Player> players, CardAction action) {
                        //TODO
                    }

                    @Override
                    public void invokeAction(Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildCellar() {
        return new Card.CardBuilder(CardName.CELLAR, CardType.KINGDOM, TWO_COST)
                .extraAction(1)
                .addCardAction((CardActionListCards) (selected, currentPlayer) -> {
                    int draws = selected.size();
                    if(draws > currentPlayer.getHandSize()) return;
                    for (Card c: selected) {
                        currentPlayer.discard(c);
                    }
                    currentPlayer.drawCards(draws);
                })
                .build();
    }

    private Card buildChapel() {

        return new Card.CardBuilder(CardName.CHAPEL, CardType.KINGDOM, TWO_COST)
                .addCardAction((CardActionListCards) (selected, currentPlayer) -> {
                    assert(selected.size() <= MAX_CHAPEL_DISCARDS);
                    for(Card c: selected){
                        currentPlayer.trash(c);
                    }
                })
                .build();
    }

    private Card buildCouncilRoom() {
        return new Card.CardBuilder(CardName.COUNCIL_ROOM, CardType.KINGDOM, FIVE_COST)
                .extraCard(4)
                .extraBuy(1)
                .addCardAction(new CardActionAffectAll() {
                    @Override
                    public void affectAll(LinkedList<Player> players) {
                        //TODO all draw except current player
                    }

                    @Override
                    public void invokeAction(Player currentPlayer) {
                        //TODO none
                    }
                })
                .build();
    }

    private Card buildFestival() {
        return new Card.CardBuilder(CardName.FESTIVAL, CardType.KINGDOM, FIVE_COST)
                .extraAction(2)
                .extraBuy(1)
                .extraGold(2)
                .build();
    }

    private Card buildGardens() {
        return new Card.CardBuilder(CardName.GARDENS, CardType.KINGDOM, FOUR_COST)
                .addCardAction((CardActionVictory) () -> {
                    //TODO
                })
                .build();
    }

    private Card buildHarbinger() {
        return new Card.CardBuilder(CardName.HARBINGER, CardType.KINGDOM, THREE_COST)
                .extraCard(1)
                .extraAction(1)
                .addCardAction((CardActionSingleCard) (card, currentPlayer) -> {
                    currentPlayer.removeFromDiscard(card);
                    currentPlayer.putOnDeck(card);
                    //TODO limit selection to discard
                })
                .build();
    }

    private Card buildLaboratory() {
        return new Card.CardBuilder(CardName.LABORATORY, CardType.KINGDOM,  FIVE_COST)
                .extraAction(1)
                .extraCard(2)
                .build();
    }

    private Card buildLibrary() {
        return new Card.CardBuilder(CardName.LIBRARY, CardType.KINGDOM, FIVE_COST)
                .addCardAction(new CardActionSimple() {
                    @Override
                    public void invokeAction(Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildMarket() {
        return new Card.CardBuilder(CardName.MARKET, CardType.KINGDOM,  FIVE_COST)
                .extraBuy(1)
                .extraAction(1)
                .extraCard(1)
                .extraGold(1)
                .build();
    }

    private Card buildMerchant() {
        return new Card.CardBuilder(CardName.MERCHANT, CardType.KINGDOM, THREE_COST)
                .extraCard(1)
                .extraAction(1)
                .build();
    }

    private Card buildMilitia() {
        return new Card.CardBuilder(CardName.MILITIA, CardType.KINGDOM, FOUR_COST)
                .extraGold(2)
                .addCardAction(new CardActionAttack() {
                    @Override
                    public void attack(ArrayList<Player> players, CardAction action) {

                    }

                    @Override
                    public void invokeAction(Player currentPlayer) {
                        //TODO leave blank
                    }
                })
                .build();
    }

    private Card buildMine() {
        return new Card.CardBuilder(CardName.MINE, CardType.KINGDOM, FIVE_COST)
                .addCardAction((CardActionSingleCard) (card, currentPlayer) -> {
                    //TODO
                })
                .build();
    }

    private Card buildMoat() {
        return new Card.CardBuilder(CardName.MOAT, CardType.KINGDOM, TWO_COST)
                .extraCard(2)
                .addCardAction(new CardActionReaction(){})
                .build();
    }

    private Card buildMoneylender() {
        return new Card.CardBuilder(CardName.MONEYLENDER, CardType.KINGDOM, FOUR_COST)
                .addCardAction(new CardActionSingleCard() {
                    @Override
                    public void invokeAction(Card card, Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildPoacher() {
        return new Card.CardBuilder(CardName.POACHER, CardType.KINGDOM, FOUR_COST)
                .extraCard(1)
                .extraAction(1)
                .extraGold(1)
                .addCardAction(new CardActionSimple() {
                    @Override
                    public void invokeAction(Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildRemodel() {
        return new Card.CardBuilder(CardName.REMODEL, CardType.KINGDOM, FOUR_COST)
                .addCardAction(new CardActionSingleCard() {
                    @Override
                    public void invokeAction(Card card, Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildSentry() {
        return new Card.CardBuilder(CardName.SENTRY, CardType.KINGDOM, FIVE_COST)
                .extraCard(1)
                .extraAction(1)
                .addCardAction(new CardActionListCards() {
                    @Override
                    public void invokeAction(ArrayList<Card> selected, Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildSmithy() {
        return new Card.CardBuilder(CardName.SMITHY, CardType.KINGDOM,  4)
                .extraCard(3)
                .build();
    }

    private Card buildThroneRoom() {
        return new Card.CardBuilder(CardName.THRONE_ROOM, CardType.KINGDOM, FOUR_COST)
                .addCardAction(new CardActionSingleCard() {
                    @Override
                    public void invokeAction(Card card, Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildVassal() {
        return new Card.CardBuilder(CardName.VASSAL, CardType.KINGDOM, THREE_COST)
                .extraGold(2)
                .addCardAction((CardActionSimple) currentPlayer -> {
                    //TODO
                })
                .build();
    }

    private Card buildVillage() {
        return new Card.CardBuilder(CardName.VILLAGE, CardType.KINGDOM,  THREE_COST)
                .extraAction(2)
                .extraCard(1)
                .build();
    }

    private Card buildWitch() {
        return new Card.CardBuilder(CardName.WITCH, CardType.KINGDOM, FIVE_COST)
                .extraCard(2)
                .addCardAction(new CardActionAttack() {
                    @Override
                    public void attack(ArrayList<Player> players, CardAction action) {
                        //TODO
                    }

                    @Override
                    public void invokeAction(Player currentPlayer) {
                        //TODO none
                    }
                })
                .build();
    }

    private Card buildWorkshop() {
        return new Card.CardBuilder(CardName.WORKSHOP, CardType.KINGDOM, THREE_COST)
                .addCardAction((CardActionSingleCard) (card, currentPlayer) -> {
                    //TODO
                })
                .build();
    }





}
