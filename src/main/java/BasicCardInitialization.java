import java.util.ArrayList;
import java.util.List;

/**
 * Cards in every game
 */
public final class BasicCardInitialization {
    private static final int COPPER_COUNT = 60;
    public static final String COPPER = "Copper";

    private static final int SILVER_COUNT = 40;
    public static final String SILVER = "Silver";

    private static final int GOLD_COUNT = 30;
    public static final String GOLD = "Gold";

    private static final int ESTATE_COUNT = 24;
    public static final String ESTATE = "Estate";

    private static final int DUCHY_COUNT = 12;
    public static final String DUCHY = "Duchy";

    private static final int PROVINCE_COUNT = 12;
    public static final String PROVINCE = "Province";

    public static final int CURSE_COUNT = 30;
    public static final String CURSE = "Curse";




    private BasicCardInitialization(){}

    /**
     *
     * @return the basic cards
     */
    public static List<Card> generateStartingCards(){
        ArrayList<Card> gameCards = new ArrayList<>();
        gameCards.add(new Card.CardBuilder(COPPER, CardType.TREASURE, 0)
                .build());

        gameCards.add(new Card.CardBuilder(SILVER, CardType.TREASURE,  3)
                .build());

        gameCards.add(new Card.CardBuilder(GOLD, CardType.TREASURE, 6)
                .build());

        gameCards.add(new Card.CardBuilder(CURSE, CardType.CURSE, 0)
                .build());

        gameCards.add(new Card.CardBuilder(ESTATE, CardType.VICTORY,  2)
                .build());

        gameCards.add(new Card.CardBuilder(DUCHY, CardType.VICTORY,  5)
                .build());

        gameCards.add(new Card.CardBuilder(PROVINCE, CardType.VICTORY, 8)
                .build());

        return gameCards;
    }
}
