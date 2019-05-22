package model;

import util.SplitGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    private List<Lotto> myLotto;
    private LottoMachine lottoMachine;

    public Person() {
        myLotto = new ArrayList<>();
        lottoMachine = new LottoMachine();
    }

    public List<String> buyLotto(int money, List<String> lottoNumbers) {
        lottoMachine.inputMoney(money);

        lottoNumbers.forEach(this::buyDirectLotto);
        while (lottoMachine.canLotto()) {
            buyAutoLotto();
        }

        return getHistory();
    }

    private void buyAutoLotto() {
        myLotto.add(lottoMachine.getAutoLotto());
    }

    private void buyDirectLotto(String numbers) {
        myLotto.add(lottoMachine.getDirectLotto(numbers));
    }

    private List<String> getHistory() {
        List<String> history = new ArrayList<>();

        for (Lotto lotto : myLotto)
            history.add(lotto.showLotto());

        return history;
    }

    public Statistic checkLotto(String winningNumbers, String bonusNumber) {
        Statistic statistic = new Statistic();
        List<String> winningNumber = Arrays.asList(SplitGenerator.splitWithSign(winningNumbers, ", "));

        for (Lotto lotto : myLotto)
            statistic.pushStatistic(Rank.valueOf(lotto.getCorrectCount(winningNumber), lotto.isContain(bonusNumber)));

        return statistic;
    }
}
