package core;

import java.util.ArrayList;
import java.util.List;

/**
 * Cards in every game
 */
public final class BasicCardInitialization {
    private static final int COPPER_COUNT = 60;


    private static final int SILVER_COUNT = 40;


    private static final int GOLD_COUNT = 30;


    private static final int ESTATE_COUNT = 24;


    private static final int DUCHY_COUNT = 12;


    private static final int PROVINCE_COUNT = 12;


    public static final int CURSE_COUNT = 30;





    private BasicCardInitialization(){}

    /**
     *
     * @return the basic cards
     */
    public static List<Card> generateStartingCards(){
        ArrayList<Card> gameCards = new ArrayList<>();
        gameCards.add(new Card.CardBuilder(CardName.COPPER, CardType.TREASURE, 0)
                .build());

        gameCards.add(new Card.CardBuilder(CardName.SILVER, CardType.TREASURE,  3)
                .build());

        gameCards.add(new Card.CardBuilder(CardName.GOLD, CardType.TREASURE, 6)
                .build());

        gameCards.add(new Card.CardBuilder(CardName.CURSE, CardType.CURSE, 0)
                .build());

        gameCards.add(new Card.CardBuilder(CardName.ESTATE, CardType.VICTORY,  2)
                .build());

        gameCards.add(new Card.CardBuilder(CardName.DUCHY, CardType.VICTORY,  5)
                .build());

        gameCards.add(new Card.CardBuilder(CardName.PROVINCE, CardType.VICTORY, 8)
                .build());

        return gameCards;
    }
}
