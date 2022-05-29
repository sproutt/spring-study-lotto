public class Money {
    private static final int MIN_MONEY = 1000;
    private int money;

    public Money(int money){
        validate_over_1000(money);
        validate_money_divide_by_1000(money);
        this.money = money;
    }

    private void validate_over_1000(int money){
        if (money < MIN_MONEY){
            throw new IllegalArgumentException();
        }
    }

    private void validate_money_divide_by_1000(int money){
        if (!(money % 1000 == 0)){
            throw new IllegalArgumentException();
        }
    }
}