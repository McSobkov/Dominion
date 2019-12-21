import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;


public class BigTest {
    Dominion dominion;

    @Before
    public void initialize(){
        dominion = new Dominion();
        ArrayList<String> gameCards = new ArrayList<>();
        gameCards.add("Village");
        dominion.initializeGame(gameCards);
    }

    @Test
    public void cardInitializations(){
        ArrayList<Card> gameCards = dominion.getGameCards();
        assertEquals("Copper", gameCards.get(0).getName());
        //assertEquals(60, gameCards.get(0).getCount());
    }

}
