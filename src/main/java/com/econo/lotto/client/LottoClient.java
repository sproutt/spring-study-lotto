package com.econo.lotto.client;

import com.econo.lotto.domain.LottoGame;
import com.econo.lotto.domain.LottoMatcher;
import com.econo.lotto.view.InputView;
import com.econo.lotto.view.OutputView;

import java.io.IOException;

public class LottoClient {

    public static void main(String[] args) throws IOException {
        LottoGame lottoGame = new LottoGame();
        LottoMatcher lottoMatcher = new LottoMatcher();

        lottoGame.setLottos(InputView.readExpenditure());
        lottoMatcher.setWinNumbers(InputView.readWinNumbers());
    }
}
