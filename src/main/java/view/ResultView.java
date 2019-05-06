package view;

import model.StringAddCalculator;

public class ResultView {
    public static void resultView(StringAddCalculator stringAddCalculator, String string) {
        System.out.println(stringAddCalculator.calculate(string));
    }
}
