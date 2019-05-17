package LottoTDD.model;

public class Lotto {
    private int numberOfLotto;

    public int calculateLotto(int money){
        numberOfLotto = money/1000;
        return numberOfLotto;
    }
}
