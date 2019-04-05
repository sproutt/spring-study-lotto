package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private int number;

    public LottoNumber() {
    }

    public LottoNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean equals(LottoNumber lottoNumber) {
        return this.number == lottoNumber.number;
    }

    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber compareLottoNumber) {
        int compareNumber = ((LottoNumber) compareLottoNumber).number;
        return this.number - compareNumber;
    }
}