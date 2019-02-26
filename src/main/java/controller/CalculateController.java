package controller;

import model.Function;
import view.OutputView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateController {

    private final String CUSTOMCHECKER = "//(.)\n(.*)";
    private final String DEFAULTCHECKER = ",|:";

    private Function function = new Function();

    private void checkNull(String input) {
        if (input.isEmpty()) {
            OutputView.printZero();
            System.exit(0);
        }
    }

    public String[] splitString(String input) {
        Matcher matcher = Pattern.compile(CUSTOMCHECKER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DEFAULTCHECKER);
    }

    public int add(String input) {
        checkNull(input);
        function.addNumbers(splitString(input));
        return this.function.getResult();
    }

}
