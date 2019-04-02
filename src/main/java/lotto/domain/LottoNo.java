package lotto.domain;

public class LottoNo {
    private int number;

    public LottoNo() {
    }

    public LottoNo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean equals(LottoNo number) {
        return this.number == number.getNumber();
    }

}
