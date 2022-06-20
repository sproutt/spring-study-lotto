import exception.LottoNumberOutOfRangeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final String LOTTO_NUMBER_OUT_OF_RANGE = "로또 번호가 범위(1~45) 밖에 있습니다";
    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    private final int number;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumberCache.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(int number) {
        validateLottoNumberRange(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumberCache.get(number);
        if (lottoNumber == null) {
            throw new LottoNumberOutOfRangeException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
        return lottoNumber;
    }

    private void validateLottoNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoNumberOutOfRangeException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    public int getNumber() {
        return number;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}