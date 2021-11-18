package libraryTest;

<<<<<<< HEAD
public class DiceTest {}
=======
import library.Dice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



public class DiceTest {
    Dice dice =new Dice();

    @Test
    public void testroll(){
        Dice dice =new Dice();
        int F1 = dice.getFaceValue1();
        int F2 = dice.getFaceValue2();
        int calculatedSum= F1+F2;
        Assertions.assertEquals(calculatedSum,dice.getDiceTotal());
    }


}
>>>>>>> c2780d6c940e677cdc2114e685bfd54989bc3e0e
