package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
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
}