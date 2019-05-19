package LottoTDD.model;

import java.util.ArrayList;
import java.util.List;

public class SettingLotto {
    private List<List<Integer>> lottoss;
    private Lotto lotto;

    public List<List<Integer>> lottoGenerator(int numberOfLotto) {
        lottoss = new ArrayList<List<Integer>>();
        for (int i = 0; i < numberOfLotto; i++) {
            lotto = new Lotto();
            lottoss.add(lotto.playLotto());
        }
        return lottoss;
    }
}
