import exception.MoneyUnderMinMoneyException;

public class Money {
    private static final int MIN_MONEY = 1000;
    private static final String OVER_MIN_MONEY_MESSAGE = "지불한 금액이 1000원 이상이어야 합니다.";
    private final int money;

    public Money(int money) {
        validateOverMinMoney(money);
        this.money = money;
    }

    private void validateOverMinMoney(int money) {
        if (money < MIN_MONEY) {
            throw new MoneyUnderMinMoneyException(OVER_MIN_MONEY_MESSAGE);
        }
    }
}