package lotto.domain;

import java.util.List;

public class Lotto {
    private List<LottoNo> lotto;

    public Lotto(List<LottoNo> lotto) {
        this.lotto = lotto
    }

    public List<LottoNo> getLotto() {
        return lotto;
    }

    public void setLotto(List<LottoNo> lotto) {
        this.lotto = lotto;
    }

    public boolean isContain(LottoNo number) {
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
