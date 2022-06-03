public class Money {
    private static final int MIN_MONEY = 1000;
    private static final String OVER_MIN_MONEY_MESSAGE = "지불한 금액이 1000원 이상이어야 합니다.";
    private final int money;

    public Money(int money) {
        validateOverMIN_MONEY(money);
        this.money = money;
    }

    private void validateOverMIN_MONEY(int money) {
        if (money < MIN_MONEY) {
            throw new ValidateOver_MIN_MONEY_Exception(OVER_MIN_MONEY_MESSAGE);
        }
    }

    public class ValidateOver_MIN_MONEY_Exception extends RuntimeException{
        public ValidateOver_MIN_MONEY_Exception(String message){
            System.out.println(message);
        }
    }
}