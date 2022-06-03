import java.util.Objects;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String LOTTO_NUMBER_OUT_OF_RANGE = "로또 번호가 범위(1~45) 밖에 있습니다";

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumberRange(number);
        this.number = number;
    }

    private void validateLottoNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new ValidateLottoNumberRangeException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    public int getNumber() {
        return number;
    }

    public class ValidateLottoNumberRangeException extends RuntimeException{
        public ValidateLottoNumberRangeException(String message){
            System.out.println(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
