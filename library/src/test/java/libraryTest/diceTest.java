package libraryTest;


import library.Dice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class DiceTest {


    // making a dice object
    Dice dice =new Dice();


    // testing dice roll method
    @Test
    public void testroll(){
        int F1 = dice.getFaceValue1();
        int F2 = dice.getFaceValue2();
        int calculatedSum= F1+F2;
        Assertions.assertEquals(calculatedSum,dice.getDiceTotal());
    }


}

