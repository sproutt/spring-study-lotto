package model;

import util.ListGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static int LOTTO_RANGE = 45;
    private static int LOTTO_NUMBER_COUNT = 6;
    List<Integer> winningNumber;
    List<Lotto> lottos = new ArrayList<>();

    LottoMachine(List<Integer> winningNumber, int lottoCount){
        this.winningNumber = winningNumber;
        buyLottos(lottoCount);
    }

    public void buyLottos(int lottoCount){
        for (int i=0; i<lottoCount; i++){
            getLotto();
        }
    }

    private List<Integer> getRandomNumbers(int n){
        List array = ListGenerator.getNumberList(n);
        Collections.shuffle(array);
        return array;
    }

    private void getLotto(){
        lottos.add(new Lotto(getRandomNumbers(LOTTO_RANGE).subList(0,LOTTO_NUMBER_COUNT)));
    }

    public int[] getStatisics() {
        int[] statisic = new int[7];
        for (Lotto lotto : lottos){
            statisic[lotto.getCountOk(winningNumber)]++;
        }
        return statisic;
    }

    public List<String> showLottos(){
        List<String> lottoHistory = new ArrayList<>();
        for (Lotto lotto : lottos){
            lottoHistory.add(lotto.showLotto());
        }
        return lottoHistory;
    }
}
