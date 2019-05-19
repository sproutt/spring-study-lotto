package LottoTDD.model;

public class CalculateLotto {
    private int numberOfLotto;

    public int getInputMoney() {
        return inputMoney;
    }

    private int inputMoney;
    public int calculateLotto(int money){
        inputMoney = money;
        numberOfLotto = inputMoney/1000;
        return numberOfLotto;
    }
}
