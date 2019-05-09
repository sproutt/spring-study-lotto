package controll;

import model.StringAddCalculator;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class StringAddCalculatorMain {
    public static void main(String[] args) {
        ResultView.resultView(new StringAddCalculator(), InputView.inputString(new Scanner(System.in)));
    }
}
