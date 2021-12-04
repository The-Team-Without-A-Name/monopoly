package library;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * @author Rowan, Pawan
 * Card class that contains information about community chest cards and chance cards
 */
public class Card {
    @Getter
    private CardType type;      //whether community chest card or chance card

    @Getter
    private String text1;       // information about card

    @Getter
    private String text2;

    @Getter @Setter
    private int value;          //money earned or loss

    @Getter
    private boolean outJailFree; //out of jail free or not

    @Getter
    private int house;

    @Getter
    private int travelTo;

    @Getter
    private int hotel;
// select random val to change player budget
    public static int CardValue(){
        int[] cardVals = {200, -50, 50, 100, -100, -50, 25, 10, 100};
        Random r = new Random();
        int arrayVal = r.nextInt(cardVals.length);

        return cardVals[arrayVal];
    }
    //function to select random string to be displayed upon drawing card.
    public static String ChanceString(int arrayVal){
        String[] posstringCases = {"Congratulations! you won: ", "You won a competition! gain: " };
        String[] negstringCases = {"Bad luck, you lose: ",  "Car accident, lose: " };
        Random rString = new Random();
        String stringCase="";

        if (arrayVal >0){
            int posString = rString.nextInt(posstringCases.length);
            stringCase = (posstringCases[posString]);
        }
        else if(arrayVal <0){
            int negString = rString.nextInt(negstringCases.length);
            stringCase = (negstringCases[negString]);
        }
        return stringCase;
    }

    public Card(CardType type, int value){
        if (!type.equals(CardType.CHANCE) && !type.equals(CardType.COMMUNITY))
            throw new IllegalArgumentException("Invalid card type!!");
        if (type.equals(CardType.CHANCE))
            chanceBlock(value);
        else
            communityBlock(value);
    }

    public boolean outJailFree() {
        return outJailFree;
    }

    /**
     * enum for community and chance which makes easy process for recognizing types
     */
    public enum CardType{
        CHANCE,COMMUNITY
    }

    /**
     * various cases for chance cards
     */
    private void chanceBlock(int value) {
        type = CardType.CHANCE;
        switch (value) {
            case 0 -> boardwalk();
            case 1 -> go();
            case 2 -> Illinois();
            case 3 -> stCharles();
            case 4 -> railroad();
            case 5 -> prize();
            case 6 -> utility();
            case 7 -> bank();
            case 8 -> jailFree();
            case 9 -> goBack();
            case 10 -> go_TOJail();
            case 11 -> repairs();
            case 12 -> speeding();
            case 13 -> trip();
            case 14 -> chairman();
            case 15 -> loan();
            default -> {
            }
        }
    }

    private void boardwalk() {
        text1 = "Advance to Boardwalk";
    }

    private void go() {
        text1 = "Advance to Go";
        text2 = "Collect 200$";
        value = 200;

    }

    private void Illinois() {
        text1 = "Advance to Illinois Avenue";
        text2 = "If you pass Go, collect $200";

    }

    private void stCharles() {
        text1 = "Advance to St.Charles Place";
        text2 = "If you pass Go, collect $200";
    }

    private void railroad() {
        text1 = "If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled";

    }

    private void prize() {
        text1 = "you have won $100";
        value = 100;
    }

    private void utility() {
        text1 = "If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown";

    }

    private void bank() {
        text1 = "Bank pays you dividend of $50";
        value = 50;
    }


    private void jailFree() {
        text1 = "Get out of jail free!!";
        outJailFree = true;
    }

    private void goBack() {
        text1 = "Go back 3 spaces";
        travelTo = 0;
    }

    private void go_TOJail() {
        text1 = "Go directly to Jail, no money!";

    }

    private void repairs() {
        text1 = "Make general repairs on all your property";
        text2 = "For each house pay $25. For each hotel pay $100";
        house = -25;
        hotel = -100;
    }

    private void speeding() {
        text1 = "You are fined $15 for speeding!";
        value = -15;
    }

    private void trip() {
        text1 = "Take a trip to Reading Railroad!";
        text2 = "If you pass Go, collect $200";
    }

    private void chairman(){
        text1 = "You have been elected as Chairman of the Board";
        text2 = "Pay each player $50";
        value = -50;  //since two players for now
    }

    private void loan(){
        text1 = "Your building loan matures";
        text2 = "Collect $150";
        value = 150;
    }

    /**
     * various community card cases
     */
    private void communityBlock(int value) {
        type = CardType.COMMUNITY;
        switch (value) {
            case 0 -> go_1();
            case 1 -> bankError();
            case 2 -> doctor();
            case 3 -> stock();
            case 4 -> outOfJailFree();
            case 5 -> goToJail();
            case 6 -> holiday();
            case 7 -> incomeTaxRefund();
            case 8 -> birthday();
            case 9 -> insurance();
            case 10 -> hospital();
            case 11 -> school();
            case 12 -> consultancy();
            case 13 -> repair();
            case 14 -> beauty();
            case 15 -> inherit();
            default -> {
            }
        }
    }

    private void go_1() {
        text1 = "Collect $200";
        value = 200;
    }

    private void bankError() {
        text1 = "Bank error in your favor";
        text2 = "Collect 200";
        value = 200;
    }

    private void doctor() {
        text1 = "Doctor's fee!";
        text2 = "pay $50";
        value = -50;
    }

    private void stock() {
        text1 = "sell the stock";
        text2 = "get $50";
        value = 50;
    }

    private void outOfJailFree() {
        text1 = "Get out of jail free";
    }

    private void goToJail() {
        text1 = "Directly go to jail!";
    }

    private void holiday() {
        text1 = "receive $200 from holiday fund!";
        value = 200;
    }

    private void incomeTaxRefund() {
        text1 = "get $20 income tax refund";
        value = 20;

    }

    private void birthday() {
        text1 = "Collect $10 from each player";
        value = 10;  //two players for now
    }

    private void insurance() {
        text1 = "collect $100 as life insurance matures";
        value = 100;
    }

    private void hospital() {
        text1 = "pay $100 hospital fees";
        value = 100;
    }

    private void school() {
        text1 = "pay $50 school fees";
        value = 50;
    }

    private void consultancy(){
        text1 = "pay $25 consultancy fees";
        value = -25;
    }

    private void repair(){
        text1 = "street repair!";
        text2 = "$40 per house, $115 per hotel";
    }

    private void beauty(){
        text1 = "you won $10 in beauty contest";
        value = 10;
    }

    private void inherit(){
        text1 = "You inherit $100!";
        value = 100;
    }


}
