package LottoTDD.model;

import java.util.ArrayList;
import java.util.List;

public class SettingLotto {
    private List<Lotto> lottoss;
    private Lotto lotto;
    public List<Lotto> settingLotto(int numberOfLotto) {
        lottoss = new ArrayList<Lotto>();
        for (int i = 0; i <  numberOfLotto; i++) {
            lotto = new Lotto();
            lottoss.add((Lotto) lotto.lottoGenerator());
        }
        return lottoss;
    }
}
