package library;

import java.util.Random;

/**
 * Dice class has face values and rolls.
 */

//this class handles dice
public class Dice {

    private  int diceTotal;
    private  int faceValue1;
    private  int faceValue2;
    private Random randNum=new Random();
    private boolean db;


   // constructor for dice object
    public Dice(){

    }

    //get sum of the faces of this roll
    public int getDiceTotal() {
        return diceTotal;
    }

    public int getFaceValue1() {
        return faceValue1;
    }

    public int getFaceValue2() {
        return faceValue2;
    }

    //method for rolling dice
    public void roll(){

        //this method should have some functionality to change the db(boolean) when two facevalues are equal.
    }

    //returns true if last roll was double
    public boolean isDouble(){
        return db;
    }




}
