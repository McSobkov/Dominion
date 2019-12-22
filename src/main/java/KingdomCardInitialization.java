import java.util.ArrayList;
import java.util.List;

/**
 * Initializes kingdom cards
 */
public final class KingdomCardInitialization {

    private static final int TWO_COST = 2;
    private static final int THREE_COST = 3;
    private static final int FOUR_COST = 4;
    private static final int FIVE_COST = 5;
    private static final int NUM_PILES = 10;
    private static final int ACTION_COUNT = 10;



    private KingdomCardInitialization(){}

    /**
     *
     * @param names of kingdom cards
     * @return list of cards in kingdom
     */
    public static List<Card> chooseCards(List<String> names){
        //assert(names.size() == NUM_PILES);
        ArrayList<String> cardNames = (ArrayList<String>) names;
        ArrayList<Card> gameCards = new ArrayList<>();
        for(String s: cardNames){

            switch (s){
                default: break;
                case "Cellar": gameCards.add(buildCellar()); break;
                case "Chapel": gameCards.add(buildChapel()); break;
                case "Festival": gameCards.add(buildFestival()); break;
                case "Laboratory": gameCards.add(buildLaboratory()); break;
                case "Market": gameCards.add(buildMarket()); break;
                case "Smithy": gameCards.add(buildSmithy()); break;
                case "Village": gameCards.add(buildVillage()); break;

            }
        }
        return gameCards;
    }



    private static Card buildCellar() {
        return new Card.CardBuilder("Cellar", CardType.KINGDOM, TWO_COST)
                .extraAction(1)
                .addCardAction(new CardActionListCards() {
                    @Override
                    public void invokeAction(ArrayList<Card> selected, Player currentPlayer) {
                        int draws = selected.size();
                        if(draws > currentPlayer.getHandSize()) return;
                        for (Card c: selected) {
                            assert(currentPlayer.discard(c));
                        }
                        currentPlayer.drawCards(draws);
                    }
                })
                .build();
    }

    private static Card buildChapel() {
        return new Card.CardBuilder("Chapel", CardType.KINGDOM, TWO_COST)
                //.addCardAction(new CardActionUpTo() {
                   //TODO later
                //})
                .build();
    }


    private static Card buildFestival() {
        return new Card.CardBuilder("Festival", CardType.KINGDOM, FIVE_COST)
                .extraAction(2)
                .extraBuy(1)
                .extraGold(2)
                .build();
    }

    private static Card buildLaboratory() {
        return new Card.CardBuilder("Laboratory", CardType.KINGDOM,  FIVE_COST)
                .extraAction(1)
                .extraCard(2)
                .build();
    }

    private static Card buildMarket() {
        return new Card.CardBuilder("Market", CardType.KINGDOM,  FIVE_COST)
                .extraBuy(1)
                .extraAction(1)
                .extraCard(1)
                .extraGold(1)
                .build();
    }

    private static Card buildSmithy() {
        return new Card.CardBuilder("Smithy", CardType.KINGDOM,  4)
                .extraCard(3)
                .build();
    }

    private static Card buildVillage() {
        return new Card.CardBuilder("Village", CardType.KINGDOM,  3)
                .extraAction(2)
                .extraCard(1)
                .build();
    }

}
