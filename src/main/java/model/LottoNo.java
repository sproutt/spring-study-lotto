package model;

public class LottoNo {

    private int number;

    public LottoNo(int number) {
        if (number < 1 || number > 45)
            throw new IndexOutOfBoundsException("로또 번호 범위 밖의 숫자입니다."+number);
        this.number = number;
    }

    public String getStringNumber() {
        return Integer.toString(number);
    }
}
