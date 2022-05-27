public class Money {
    private static final int MIN_MONEY = 1000;
    private int money;

    public Money(int money){
        validate_over_1000(money);
        this.money = money;
    }

    private void validate_over_1000(int money){
        if (money < MIN_MONEY){
            throw new IllegalArgumentException();
        }
    }
}