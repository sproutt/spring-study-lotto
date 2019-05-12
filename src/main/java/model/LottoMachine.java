package model;

import util.ListGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static int LOTTO_RANGE = 45;
    private static int LOTTO_NUMBER_COUNT = 6;
    List<Lotto> lottos = new ArrayList<>();

    public void buyLottos(int lottoCount){
        for (int i=0; i<lottoCount; i++){
            getLotto();
        }
    }

    private List<Integer> getRandomNumbers(int range){
        List numbersInRange = ListGenerator.getNumbersInRange(range);
        Collections.shuffle(numbersInRange);
        return numbersInRange;
    }

    private void getLotto(){
        lottos.add(new Lotto(getRandomNumbers(LOTTO_RANGE).subList(0,LOTTO_NUMBER_COUNT)));
    }

    public int[] getStatistic(List<Integer> winningNumber) {
        int[] statistic = new int[7];
        for (Lotto lotto : lottos){
            statistic[lotto.getCountOk(winningNumber)]++;
        }
        return statistic;
    }

    public List<String> showLottoHistory(){
        List<String> lottoHistory = new ArrayList<>();
        for (Lotto lotto : lottos){
            lottoHistory.add(lotto.showLotto());
        }
        return lottoHistory;
    }
}
