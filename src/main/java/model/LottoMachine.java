package model;

import util.ListGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    List<Integer> answers;
    List<Lotto> lottos = new ArrayList<>();

    LottoMachine(List<Integer> answers, int lottoCount){
        this.answers = answers;
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
        lottos.add(new Lotto(getRandomNumbers(45).subList(0,6)));
    }

    public int[] getStatisics() {
        int[] statisic = new int[7];
        for (Lotto lotto : lottos){
            statisic[lotto.getCountOk(answers)]++;
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
