package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> list) {
        lotto = new ArrayList<>();
        lotto = list;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public void setLotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public boolean isContain(int number) {
        return lotto.contains(number);
    }

    public String toString() {
        return lotto.toString();
    }
}
