package controll;

import model.LottoMachine;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LottoMachine lottoMachine = new LottoMachine();
        ResultView.lottoHistoryView(lottoMachine.buyLotto(InputView.inputTotalPrice(scanner)));
        ResultView.lottoResultView(lottoMachine.getStatistic(InputView.inputNumber(scanner)));
    }
}
