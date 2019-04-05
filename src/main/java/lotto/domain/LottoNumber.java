package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber>{
    private int number;

    public LottoNumber() {
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean equals(LottoNumber lottoNumber) {
        return this.number == lottoNumber.number;
    }

    public String toString(){
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber compareLottoNumber) {
        int compareNumber=((LottoNumber)compareLottoNumber).number;
        return this.number-compareNumber;
    }
}