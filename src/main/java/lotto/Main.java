package lotto;

import lotto.domain.Lotto;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    private static Lotto lotto = new Lotto();

    public static void main(String[] args) {
        int money = Utils.purchase(InputView.inputMoney());
        lotto.makeTickets(money);
        OutputView.printEveryTickets(money);
        OutputView.printResult(InputView.inputWinnerNumber());
    }
}
