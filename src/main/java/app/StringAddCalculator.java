package app;

import controller.CalculatorController;
import view.InputView;
import view.OutputView;


public class StringAddCalculator {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();
        OutputView.printResult(calculatorController.add(InputView.inputFunction()));
    }

}
