
public class Money {
    private int cash;  //A variable to store the amount of cash in the kiosk
    //constructor
    public Money(int cash) {
        this.cash = cash;
    }
    //get && set methods
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
//Receive the money deposited by the customer and use it to update the amount of cash in the kiosk.
    public void receiveMoney(int money){
        cash += money;
    }
//Receive the value of the change needed for the user and use it to update the amount of cash in the kiosk.
    public void change(int change){
        System.out.println("Your change £" + change);
        cash -= change;
    }
}
