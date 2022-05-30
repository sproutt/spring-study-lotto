public class Money {
    private static final int MIN_MONEY = 1000;
    private final int money;

    public Money(int money) {
        validateOverMIN_MONEY(money);
        this.money = money;
    }

    private void validateOverMIN_MONEY(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException();
        }
    }
}