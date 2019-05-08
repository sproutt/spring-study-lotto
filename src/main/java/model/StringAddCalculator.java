package model;

import util.SplitGenerator;
import util.StreamGenerator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int calculate(String string) {
        if (isBlank(string))
            return 0;

        return add(splitString(string));
    }

    private String[] splitString(String string) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);
        if (matcher.find())
            return SplitGenerator.customSplitString(matcher.group(2), matcher.group(1));

        return SplitGenerator.customSplitString(string, ",|:");
    }

    private int add(String[] numbers) {
        if (!isAllPositive(numbers))
            throw new RuntimeException();

        return StreamGenerator.toIntStream(numbers).sum();
    }

    private boolean isAllPositive(String[] numbers) {
        return StreamGenerator.toIntStream(numbers).allMatch(num -> num > 0);
    }

    private boolean isBlank(String string) {
        if (string == null || string.isEmpty() || string == " ")
            return true;
        return false;
    }
}