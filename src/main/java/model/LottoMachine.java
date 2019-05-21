package model;

import util.ListGenerator;
import util.SplitGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static int LOTTO_NUMBER_RANGE = 45;
    private static int LOTTO_NUMBER_COUNT = 6;
    private static int LOTTO_PRICE = 1000;
    List<Lotto> lottos = new ArrayList<>();

    public Lotto buyAutoLotto(){
        return new Lotto(getRandomNumbers(getNumbersInRange(LOTTO_NUMBER_RANGE)));
    }

    private List<LottoNo> getNumbersInRange(int range){
        List<LottoNo> numbersInRange = new ArrayList<>();
        for (int i=0; i<range; i++){
            numbersInRange.add(new LottoNo(i));
        }
        return numbersInRange;
    }

    private List<LottoNo> getRandomNumbers(List<LottoNo> numbersInRange) {
        Collections.shuffle(numbersInRange);
        return numbersInRange.subList(0, LOTTO_NUMBER_COUNT);
    }

    public Lotto buyDirectLotto(String numbers){
        SplitGenerator.splitWithSign(numbers, ", ");
        return new Lotto()
    }


    private int[] createStatistic(List<String> winningNumber) {
        int[] statistic = new int[LOTTO_NUMBER_COUNT + 1];
        for (Lotto lotto : lottos)
            statistic[lotto.getCorrectNumberCount(winningNumber)]++;
        return statistic;
    }

    private List<String> showLottoHistory() {
        List<String> lottoHistory = new ArrayList<>();
        for (Lotto lotto : lottos)
            lottoHistory.add(lotto.showLotto());
        return lottoHistory;
    }
}
