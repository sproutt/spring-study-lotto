package com.econo.lotto.domain;

import com.econo.lotto.domain.lotto.Lotto;
import com.econo.lotto.domain.lotto.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    private LottoMatcher lottoMatcher;
    private List<Lotto> lottos;

    public LottoGame() {
        lottos = new ArrayList<>();
        lottoMatcher = new LottoMatcher();
    }

    public void setLottos(String expenditure) {
        for (int i = 0; i < toLottoCount(expenditure); i++) {
            this.save(LottoGenerator.getLotto());
        }
    }

    public void setWinNumbers(String winNumbers) {
        lottoMatcher.setWinNumbers(winNumbers);
    }

    public String getLottosPrintFormat() {
        return toLottosPrintFormat(getLottos());
    }

    public String toLottosPrintFormat(List<Lotto> lottos) {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public int toLottoCount(String expenditure) {
        return Integer.parseInt(expenditure) / LOTTO_PRICE;
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    public String[] getResults() {
        return lottoMatcher.getResults(lottos);
    }
}
