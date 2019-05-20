package LottoTDD.model;

public class CalculateLotto {
    private int numberOfLotto;
    private int inputMoney;

    public int getInputMoney() {
        return inputMoney;
    }

    public int calculateLotto(int money) {
        this.inputMoney = money;
        numberOfLotto = money / 1000;
        return numberOfLotto;
    }
}
