
public class Money {
    private int cash;

    public Money(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void receiveMoney(int money){
        cash += money;
    }

    public void change(int change){
        System.out.println("Your change £" + change);
        cash -= change;
    }
}
