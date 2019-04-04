package lotto.domain;

import java.util.List;

public class Lotto {
    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        lotto.stream().forEach(lottoNo -> stringBuilder.append(lottoNo.getNumber() + ", "));
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}