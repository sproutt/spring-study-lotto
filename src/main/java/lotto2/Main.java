package lotto2;

import lotto2.domain.LottoGame;
import lotto2.view.InputView;
import lotto2.view.OuputView;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int money = InputView.inputMoney();
        int numberOfManual =InputView.inputNumberOfManual();
        lottoGame.purchaseMenual(InputView.inputManualLottos(numberOfManual));
        OuputView.printLottos(lottoGame.purchaseAuto(money,numberOfManual),numberOfManual);
        lottoGame.setWinningLottos(InputView.inputWinningNumbers());
        lottoGame.correctBonus(InputView.inputBonusNumber());
        OuputView.printWinStats(lottoGame);
        OuputView.printRate(lottoGame.calculateRate());
    }
}
