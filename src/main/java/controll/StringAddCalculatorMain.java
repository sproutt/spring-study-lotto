package controll;

import model.StringAddCalculator;
import view.InputView;
import view.ResultView;

public class StringAddCalculatorMain {
    public static void main(String[] args) {
        ResultView.resultView(new StringAddCalculator(), InputView.inputString());
    }
}
