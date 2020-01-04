package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public static List<Stack<Card>> generateStartingCards(){
        ArrayList<Stack<Card>> gameCards = new ArrayList<>();
        gameCards.add(makeMultiple(COPPER_COUNT, CardName.COPPER, CardType.TREASURE, 0));

        gameCards.add(makeMultiple(SILVER_COUNT, CardName.SILVER, CardType.TREASURE,  3));

        gameCards.add(makeMultiple(GOLD_COUNT, CardName.GOLD, CardType.TREASURE, 6));

        gameCards.add(makeMultiple(CURSE_COUNT, CardName.CURSE, CardType.CURSE, 0));

        gameCards.add(makeMultiple(ESTATE_COUNT, CardName.ESTATE, CardType.VICTORY,  2));

        gameCards.add(makeMultiple(DUCHY_COUNT, CardName.DUCHY, CardType.VICTORY,  5));

        gameCards.add(makeMultiple(PROVINCE_COUNT, CardName.PROVINCE, CardType.VICTORY, 8));

        return gameCards;
    }

    private static Stack<Card> makeMultiple(int count, CardName name, CardType type, int cost){
        Stack<Card> currentStack = new Stack<>();
        for(int i = 0; i < count; i++) {
            currentStack.push(new Card.CardBuilder(name, type, cost).build());
        }
        return currentStack;
    }
}
