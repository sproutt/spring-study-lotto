package com.econo.lotto.domain;

import com.econo.lotto.utils.LottoGenerator;
import com.econo.lotto.view.OutputView;

import java.io.IOException;
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

    public void setLottos(String expenditure) throws IOException {
        int lottoCount = getLottoCount(expenditure);
        for (int i = 0; i < getLottoCount(expenditure); i++) {
            this.save(new Lotto(LottoGenerator.getLotto()));
        }
        OutputView.printLottoNumber(lottoCount);
        OutputView.printLottos(getLottosPrintFormat(lottos));
    }

    public void setWinNumbers(String winNumbers) {
        lottoMatcher.setWinNumbers(winNumbers);
    }

    public String getLottosPrintFormat(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::getLottoPrintFormat)
                .collect(Collectors.joining("\n"));
    }

    public String getLottoPrintFormat(Lotto lotto) {
        StringBuffer stringBuffer = new StringBuffer("[");
        String middleString = lotto.stream()
                .map(number -> Integer.toString(number))
                .collect(Collectors.joining(", "));
        stringBuffer.append(middleString);
        stringBuffer.append("]");

        return stringBuffer.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLottoCount(String expenditure) {
        return Integer.parseInt(expenditure) / LOTTO_PRICE;
    }

    public String[] getResults() {
        return lottoMatcher.getResults(lottos);
    }
}
