package controll;

import model.Person;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        ResultView.lottoHistoryView(person.buyLotto(InputView.inputTotalPrice(scanner), InputView.inputTotalLottoNumber(scanner)));
        ResultView.lottoResultView(person.checkLotto(InputView.inputNumber(scanner), InputView.inputBonusNumber(scanner)));
    }
}
