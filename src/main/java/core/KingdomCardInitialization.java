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
    public List<Card> chooseCards(List<String> names){
        //assert(names.size() == NUM_PILES);
        ArrayList<String> cardNames = (ArrayList<String>) names;
        ArrayList<Card> gameCards = new ArrayList<>();
        for(String s: cardNames){

            switch (s){
                default: break;
                case "Artisan": gameCards.add(buildArtisan()); break;
                case "Bandit": gameCards.add(buildBandit()); break;
                case "Bureaucrat": gameCards.add(buildBureaucrat()); break;
                case "Cellar": gameCards.add(buildCellar()); break;
                case "Chapel": gameCards.add(buildChapel()); break;
                case "Council Room": gameCards.add(buildCouncilRoom()); break;
                case "Gardens": gameCards.add(buildGardens()); break;
                case "Festival": gameCards.add(buildFestival()); break;
                case "Harbinger": gameCards.add(buildHarbinger()); break;
                case "Laboratory": gameCards.add(buildLaboratory()); break;
                case "Library": gameCards.add(buildLibrary()); break;
                case "Market": gameCards.add(buildMarket()); break;
                case "Merchant": gameCards.add(buildMerchant()); break;
                case "Militia": gameCards.add(buildMilitia()); break;
                case "Mine": gameCards.add(buildMine()); break;
                case "Moat": gameCards.add(buildMoat()); break;
                case "Moneylender": gameCards.add(buildMoneylender()); break;
                case "Poacher": gameCards.add(buildPoacher()); break;
                case "Remodel": gameCards.add(buildRemodel()); break;
                case "Sentry": gameCards.add(buildSentry()); break;
                case "Smithy": gameCards.add(buildSmithy()); break;
                case "Throne Room": gameCards.add(buildThroneRoom()); break;
                case "Vassal": gameCards.add(buildVassal()); break;
                case "Village": gameCards.add(buildVillage()); break;
                case "Witch": gameCards.add(buildWitch()); break;
                case "Workshop": gameCards.add(buildWorkshop()); break;


            }
        }
        return gameCards;
    }


    private Card buildArtisan() {
        return new Card.CardBuilder("Artisan", CardType.KINGDOM, SIX_COST)
                .addCardAction((CardActionSimple) currentPlayer -> {
                    //TODO
                })
                .build();
    }

    private Card buildBandit() {
        return new Card.CardBuilder("Bandit", CardType.KINGDOM, FIVE_COST)
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
        return new Card.CardBuilder("Bureaucrat", CardType.KINGDOM, FOUR_COST)
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
        return new Card.CardBuilder("Cellar", CardType.KINGDOM, TWO_COST)
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

        return new Card.CardBuilder("Chapel", CardType.KINGDOM, TWO_COST)
                .addCardAction((CardActionListCards) (selected, currentPlayer) -> {
                    assert(selected.size() <= MAX_CHAPEL_DISCARDS);
                    for(Card c: selected){
                        currentPlayer.trash(c);
                    }
                })
                .build();
    }

    private Card buildCouncilRoom() {
        return new Card.CardBuilder("Council Room", CardType.KINGDOM, FIVE_COST)
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
        return new Card.CardBuilder("Festival", CardType.KINGDOM, FIVE_COST)
                .extraAction(2)
                .extraBuy(1)
                .extraGold(2)
                .build();
    }

    private Card buildGardens() {
        return new Card.CardBuilder("Gardens", CardType.KINGDOM, FOUR_COST)
                .addCardAction((CardActionVictory) () -> {
                    //TODO
                })
                .build();
    }

    private Card buildHarbinger() {
        return new Card.CardBuilder("Harbinger", CardType.KINGDOM, THREE_COST)
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
        return new Card.CardBuilder("Laboratory", CardType.KINGDOM,  FIVE_COST)
                .extraAction(1)
                .extraCard(2)
                .build();
    }

    private Card buildLibrary() {
        return new Card.CardBuilder("Library", CardType.KINGDOM, FIVE_COST)
                .addCardAction(new CardActionSimple() {
                    @Override
                    public void invokeAction(Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildMarket() {
        return new Card.CardBuilder("Market", CardType.KINGDOM,  FIVE_COST)
                .extraBuy(1)
                .extraAction(1)
                .extraCard(1)
                .extraGold(1)
                .build();
    }

    private Card buildMerchant() {
        return new Card.CardBuilder("Merchant", CardType.KINGDOM, THREE_COST)
                .extraCard(1)
                .extraAction(1)
                .build();
    }

    private Card buildMilitia() {
        return new Card.CardBuilder("Militia", CardType.KINGDOM, FOUR_COST)
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
        return new Card.CardBuilder("Mine", CardType.KINGDOM, FIVE_COST)
                .addCardAction((CardActionSingleCard) (card, currentPlayer) -> {
                    //TODO
                })
                .build();
    }

    private Card buildMoat() {
        return new Card.CardBuilder("Moat", CardType.KINGDOM, TWO_COST)
                .extraCard(2)
                .addCardAction(new CardActionReaction(){})
                .build();
    }

    private Card buildMoneylender() {
        return new Card.CardBuilder("Moneylender", CardType.KINGDOM, FOUR_COST)
                .addCardAction(new CardActionSingleCard() {
                    @Override
                    public void invokeAction(Card card, Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildPoacher() {
        return new Card.CardBuilder("Poacher", CardType.KINGDOM, FOUR_COST)
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
        return new Card.CardBuilder("Remodel", CardType.KINGDOM, FOUR_COST)
                .addCardAction(new CardActionSingleCard() {
                    @Override
                    public void invokeAction(Card card, Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildSentry() {
        return new Card.CardBuilder("Sentry", CardType.KINGDOM, FIVE_COST)
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
        return new Card.CardBuilder("Smithy", CardType.KINGDOM,  4)
                .extraCard(3)
                .build();
    }

    private Card buildThroneRoom() {
        return new Card.CardBuilder("Throne Room", CardType.KINGDOM, FOUR_COST)
                .addCardAction(new CardActionSingleCard() {
                    @Override
                    public void invokeAction(Card card, Player currentPlayer) {
                        //TODO
                    }
                })
                .build();
    }

    private Card buildVassal() {
        return new Card.CardBuilder("Vassal", CardType.KINGDOM, THREE_COST)
                .extraGold(2)
                .addCardAction((CardActionSimple) currentPlayer -> {
                    //TODO
                })
                .build();
    }

    private Card buildVillage() {
        return new Card.CardBuilder("Village", CardType.KINGDOM,  THREE_COST)
                .extraAction(2)
                .extraCard(1)
                .build();
    }

    private Card buildWitch() {
        return new Card.CardBuilder("Witch", CardType.KINGDOM, FIVE_COST)
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
        return new Card.CardBuilder("Workshop", CardType.KINGDOM, THREE_COST)
                .addCardAction((CardActionSingleCard) (card, currentPlayer) -> {
                    //TODO
                })
                .build();
    }





}
