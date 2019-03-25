package lotto;

import lotto.domain.LottoGame;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int money = InputView.inputMoney();
        OutputView.printLottos(lottoGame.purchase(money));
        int[] result = lottoGame.saveLottoResult(InputView.inputResult());
        OutputView.printStatistics(result);
        OutputView.printBenefitRate(lottoGame.calculateRate(result,money));
    }
}
