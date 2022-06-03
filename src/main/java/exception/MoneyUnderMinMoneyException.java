package exception;

public class MoneyUnderMinMoneyException extends RuntimeException {
    public MoneyUnderMinMoneyException(String message){
        super(message);
    }
}