package exception;

public class LottoIsNotUniqueException extends RuntimeException {
    public LottoIsNotUniqueException(String message) {
        super(message);
    }
}