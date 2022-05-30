public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    int number;

    public LottoNumber(int number){
        validateLottoNumberRange(number);
        this.number = number;
    }

    private void validateLottoNumberRange(int number){
        if (number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException();
        }
    }
}
