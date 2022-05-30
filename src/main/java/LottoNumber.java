import java.util.ArrayList;

public class LottoNumber {

    int number;

    public LottoNumber(int number){
        validate_lotto_number_range(number);
        this.number = number;
    }

    private void validate_lotto_number_range(int number){
        if (number < 1 || number > 45){
            throw new IllegalArgumentException();
        }
    }
}
