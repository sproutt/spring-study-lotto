package model;

import util.SplitGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    private List<Lotto> myLotto;
    private LottoMachine lottoMachine;
    private Statistic statistic;

    public Person() {
        myLotto = new ArrayList<>();
        lottoMachine = new LottoMachine();
        statistic = new Statistic();
    }

    public void buyLotto(int money, List<String> lottoNumbers){
        lottoMachine.inputMoney(money);

        lottoNumbers.stream().forEach((x)->buyDirectLotto(x));
        while (lottoMachine.canLotto()){
            buyAutoLotto();
        }
    }

    private void buyAutoLotto(){
        myLotto.add(lottoMachine.getAutoLotto());
    }

    private void buyDirectLotto(String numbers) {
        myLotto.add(lottoMachine.getDirectLotto(numbers));
    }

    public List<String> getHistory(){
        List<String> history = new ArrayList<>();
        for (Lotto lotto : myLotto){
            history.add(lotto.showLotto());
        }
        return history;
    }

    public Statistic checkLotto(String winningNumbers, String bonusNumber){
        List<String> winningNumber = Arrays.asList(SplitGenerator.splitWithSign(winningNumbers, ", "));
        for (Lotto lotto : myLotto){
            statistic.pushStatistic(Rank.valueOf(lotto.getCorrectCount(winningNumber), lotto.isContain(bonusNumber)));
        }
        return statistic;
    }
}
