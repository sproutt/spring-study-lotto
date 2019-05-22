package controll;

import model.Person;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person purchaser = new Person();
        ResultView.lottoHistoryView(purchaser.buyLotto(InputView.inputTotalPrice(scanner), InputView.inputTotalLottoNumber(scanner)));
        ResultView.lottoResultView(purchaser.checkLotto(InputView.inputNumber(scanner), InputView.inputBonusNumber(scanner)));
    }
}
