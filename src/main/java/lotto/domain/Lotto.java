package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public Lotto() {
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public void setLotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public boolean hasThisNumber(LottoNumber number) {
        return lotto.stream()
                .filter(lottoNo -> lottoNo.equals(number)).count() != 0;
    }

    public String toString() {
        return lotto.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ","[","]"));
    }

    public int countMatch(List<LottoNumber> winningNumber) {
        int count = 0;
        for (LottoNumber lottoNumber : winningNumber) {
            count = increaseCount(lottoNumber, count);
        }
        return count;
    }

    public int increaseCount(LottoNumber lottoNumber, int count) {
        if (this.hasThisNumber(lottoNumber)) {
            count++;
        }
        return count;
    }
}