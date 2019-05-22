package controll;

import model.LottoMachine;
import model.Person;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        LottoMachine lottoMachine = new LottoMachine();
//        ResultView.lottoHistoryView(lottoMachine.buyLotto(InputView.inputTotalPrice(scanner)));
//        ResultView.lottoResultView(lottoMachine.getStatistic(InputView.inputNumber(scanner)));
        Person person = new Person();
        person.buyLotto(InputView.inputTotalPrice(scanner), InputView.inputTotalLottoNumber(scanner)); //buy
        ResultView.lottoResultView(person.checkLotto(InputView.inputNumber(scanner), InputView.inputBonusNumber(scanner)));
    }
}
