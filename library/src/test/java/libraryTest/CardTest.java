package libraryTest;

import library.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CardTest {

    // making two card objects to test the methods
    Card card1= new Card(Card.CardType.CHANCE,5);
    Card card2=new Card(Card.CardType.COMMUNITY,1);


    @Test
    public void testCardValue() {
        int testVal = Card.CardValue();
        int[] testArray = {200, -50, 50, 100, -100, -50, 25, 10, 100};
        boolean val = Arrays.asList(testArray).contains(testVal);
        Assertions.assertTrue(val);
    }

    // test chanceblock method in Card Class
    @Test
    public void testChanceBlock(){
        Assertions.assertEquals(card1.getValue(),100);
        Assertions.assertEquals(card1.getText1(),"you have won $100");
        Assertions.assertEquals(card1.getType(), Card.CardType.CHANCE);
    }

    // test communityblock in Card Class
    @Test
    public void testCommunityBlock(){
        Assertions.assertEquals(card2.getType(), Card.CardType.COMMUNITY);
        Assertions.assertEquals(card2.getText1(),"Bank error in your favor");
        Assertions.assertEquals(card2.getText2(),"Collect 200");
        Assertions.assertEquals(card2.getValue(),200);
    }


}
