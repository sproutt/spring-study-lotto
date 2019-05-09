package view;

import model.StringAddCalculator;

public class ResultView {
    public static void resultView(StringAddCalculator stringAddCalculator, String expression) {
        System.out.println(stringAddCalculator.calculate(expression));
    }
}
