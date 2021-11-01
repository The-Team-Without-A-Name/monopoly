package library;
/**
 * Money class gets and sets money, including the increase and decrease of money.
 */
public class Money {
    private static int money;

//constructor for money class
    public Money(){ }

    //getter method
    public static int getMoney() {
        return money;
    }

    //setter method
    public static void setMoney(int money) {
        Money.money = money;
    }

    //increase money
    public void increaseMoney(int money){

    }

    //decrease money
    public void decreaseMoney(int money){

    }
}
