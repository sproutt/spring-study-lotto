package app;

import controller.CalculateController;
import view.InputView;
import view.OutputView;


public class StringAddCalculator {

    public static void main(String[] args) {
        CalculateController calculateController = new CalculateController();
        OutputView.printResult(calculateController.add(InputView.inputFunction()));
    }

}
