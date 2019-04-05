package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int money = InputView.inputMoney();
        int numberOfManual = InputView.inputNumberOfManual();
        lottoGame.purchaseManual(InputView.inputManualLottos(numberOfManual));
        OutputView.printLottos(lottoGame.purchaseAuto(money, numberOfManual), numberOfManual);
        lottoGame.setWinningLottos(InputView.inputResult(), InputView.inputBonusNumber());
        OutputView.printStatistics(lottoGame);
        OutputView.printBenefitRate(lottoGame.calculateRate(money));
    }
}