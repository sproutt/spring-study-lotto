package lotto.domain;

public class LottoNumber {
    private int number;

    public LottoNumber() {
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean equals(LottoNumber number) {
        return this.number == number.getNumber();
    }
}