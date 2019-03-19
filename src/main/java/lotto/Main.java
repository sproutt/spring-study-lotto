package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    static Lotto lotto = new Lotto();

    public static void main(String[] args) {
        int money = Utils.purchase(InputView.inputMoney());
        lotto.makeTickets(money);
        OutputView.printEveryTickets(money);
        OutputView.printResult(InputView.inputWinnerNumber());
    }
}
