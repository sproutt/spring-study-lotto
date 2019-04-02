package lotto2;

import lotto2.domain.LottoGame;
import lotto2.view.InputView;
import lotto2.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int money = InputView.inputMoney();
        int numberOfManual =InputView.inputNumberOfManual();
        lottoGame.purchaseMenual(InputView.inputManualLottos(numberOfManual));
        OutputView.printLottos(lottoGame.purchaseAuto(money,numberOfManual),numberOfManual);
        lottoGame.setWinningLottos(InputView.inputWinningNumbers());
        lottoGame.correctBonus(InputView.inputBonusNumber());
        OutputView.printWinStats(lottoGame);
        OutputView.printRate(lottoGame.calculateRate());
    }
}
