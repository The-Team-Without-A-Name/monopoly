package library;

import java.util.Random;

/** Dice class has face values and rolls. */

// this class handles dice
public class Dice {

  private static int diceTotal;
  private static int faceValue1;
  private static int faceValue2;
  private static Random randNum = new Random();
  public static boolean db; // boolean for double or not

  // constructor for dice object
  public Dice() {}

  // get sum of the faces of this roll
  public int getDiceTotal() {
    return diceTotal;
  }

  public int getFaceValue1() {
    return faceValue1;
  }

  public int getFaceValue2() {
    return faceValue2;
  }

  // method for rolling dice
  public static int roll(Player player) {

    // get the face values of dice using random numbers
    faceValue1 = randNum.nextInt(6) + 1;
    faceValue2 = randNum.nextInt(6) + 1;

    // if two face values are equal then that is a double.
    db = faceValue1 == faceValue2;
    diceTotal =
        faceValue1
            + faceValue2; // if two face values are not equal then add both to get the dice total.
    return diceTotal;
  }

  // returns true if last roll was double
  public boolean isDouble() {
    return db;
  }
}
