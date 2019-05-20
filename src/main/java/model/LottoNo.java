package model;

public class LottoNo {

    private int number;

    public LottoNo(int number){
        if(number>=1 && number<=45)
            this.number = number;
        throw new IndexOutOfBoundsException("로또 범위 밖 숫자입니다.");
    }

    public int getNumber(){
        return number;
    }
}
