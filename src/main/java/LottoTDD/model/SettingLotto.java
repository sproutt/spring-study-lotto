package LottoTDD.model;

import java.util.ArrayList;
import java.util.List;

public class SettingLotto {
    public List<Lotto> lottoss;
    public List<Lotto> settingLotto(int numberOfLotto) {
        lottoss = new ArrayList<Lotto>();
        for (int i = 0; i <  numberOfLotto; i++) {
            Lotto lotto = new Lotto();
            lottoss.add(lotto);
        }
        return lottoss;
    }
}
