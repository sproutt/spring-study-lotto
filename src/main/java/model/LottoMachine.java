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

    public List<String> buyLotto(int totalLottoPrice){
        for (int i=0; i<getLottoCount(totalLottoPrice); i++){
            lottos.add(new Lotto(getRandomNumbers(LOTTO_NUMBER_RANGE)));
        }
        return showLottoHistory();
    }

    private int getLottoCount(int totalPrice){
        return totalPrice/LOTTO_PRICE;
    }

    private List<String> getRandomNumbers(int range){
        List numbersInRange = ListGenerator.getNumbersInRange(range);
        Collections.shuffle(numbersInRange);
        return numbersInRange.subList(0,LOTTO_NUMBER_COUNT);
    }

    public int[] getStatistic(String winningNumber){
        return createStatistic(convertList(winningNumber));
    }

    private List<String> convertList(String winningNumber){
        return Arrays.asList(SplitGenerator.splitWithSign(winningNumber, ", "));
    }

    private int[] createStatistic(List<String> winningNumber) {
        int[] statistic = new int[LOTTO_NUMBER_COUNT+1];
        for (Lotto lotto : lottos){
            statistic[lotto.getCorrectNumberCount(winningNumber)]++;
        }
        return statistic;
    }

    private List<String> showLottoHistory(){
        List<String> lottoHistory = new ArrayList<>();
        for (Lotto lotto : lottos){
            lottoHistory.add(lotto.showLotto());
        }
        return lottoHistory;
    }
}
