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

    private int add(String[] strings) {
        if (!isAllPositive(strings))
            throw new RuntimeException();

        return StreamGenerator.stringToIntStream(strings).sum();
    }

    private boolean isAllPositive(String[] strings) {
        return StreamGenerator.stringToIntStream(strings).allMatch(num -> num > 0);
    }

    private boolean isBlank(String string) {
        if (string == null || string.isEmpty())
            return true;
        return false;
    }
}