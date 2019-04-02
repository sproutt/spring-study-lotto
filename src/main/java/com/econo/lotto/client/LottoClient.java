package com.econo.lotto.client;

import com.econo.lotto.domain.LottoGame;
import com.econo.lotto.view.InputView;
import com.econo.lotto.view.OutputView;

import java.io.IOException;

public class LottoClient {

    public static void main(String[] args) throws IOException {
        LottoGame lottoGame = new LottoGame();
        lottoGame.setLottos(InputView.readExpenditure());

        OutputView.printLottoNumber(lottoGame.getLottoCount());
        OutputView.printLottos(lottoGame.getLottosPrintFormat());

        lottoGame.setWinNumbers(InputView.readWinNumbers());

        OutputView.printResults(lottoGame.getResults());
    }
}
