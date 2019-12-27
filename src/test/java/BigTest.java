import core.Card;
import core.CardType;
import core.Player;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;


public class BigTest {
    @Test
    public void draw(){
        Player p = new Player();
        assertEquals(0, p.getHand().size());
        p.gain(new Card.CardBuilder("A", CardType.KINGDOM, 5).build());
        p.drawCards(1);
        assertEquals(1, p.getHand().size());
    }

}
