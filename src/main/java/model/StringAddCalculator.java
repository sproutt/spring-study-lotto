package model;

import util.SplitGenerator;
import util.StreamGenerator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int calculate(String expression) {
        if (isBlank(expression))
            return 0;

        return add(splitExpression(expression));
    }

    private String[] splitExpression(String expression) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (matcher.find())
            return SplitGenerator.splitWithSign(matcher.group(2), matcher.group(1));

        return SplitGenerator.splitWithSign(expression, ",|:");
    }

    private int add(String[] numbers) {
        if (!isAllPositive(numbers))
            throw new RuntimeException();

        return StreamGenerator.toIntStream(numbers).sum();
    }

    private boolean isAllPositive(String[] numbers) {
        return StreamGenerator.toIntStream(numbers).allMatch(num -> num > 0);
    }

    private boolean isBlank(String expression) {
        if (expression == null || expression.isEmpty() || expression == " ")
            return true;
        return false;
    }
}