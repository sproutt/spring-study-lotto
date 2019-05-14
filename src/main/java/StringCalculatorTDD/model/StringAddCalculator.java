package StringCalculatorTDD.model;

import java.util.regex.*;

public class StringAddCalculator {
    private int sum = 0;
    private String[] numbers = {};

    public int add(String string) {
        if (string == null) {
            return sum;
        }
        if (string.isEmpty()) {
            return sum;
        }
        if(string.charAt(0)=='/'){
            calculateCustomDividerString(string);
        }
        if (string.length() == 1) {
            sum = checkOneNum(string);
        }
        if (string.length() > 1 && string.charAt(0) !='/') {
            numbers = splitString(string);
            calculateString(numbers);
        }
        return sum;
    }

    private void calculateCustomDividerString(String string) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers= m.group(2).split(customDelimiter);
            calculateString(numbers);
        }
    }

    private void calculateString(String[] numbers) {
        for (String e : numbers) {
            sum += Integer.parseInt(e);
        }
    }

    private int checkOneNum(String string) {
        return Integer.parseInt(string);
    }

    private String[] splitString(String string) {
        numbers = string.split(",|:");
        return numbers;
    }
}