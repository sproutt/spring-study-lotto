package exception;

public class BonusNumberDuplicatedException extends RuntimeException{
    public BonusNumberDuplicatedException(String message) {
        super(message);
    }
}
