package com.econo.lotto;

import com.econo.lotto.exception.NagativeNumberException;
import com.econo.lotto.exception.NumberFormatException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {

    public int calculate(String input) {
        
        return compute(toNumbers(tokenize(input)));
    }

    public String getSeparator(String stringWithSeparator) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(stringWithSeparator);
        matcher.matches();

        return matcher.group(1);
    }

    public boolean hasSeparator(String stringWithSeparator) {

        return Pattern.compile("//(.)\n(.*)").matcher(stringWithSeparator).find();
    }

    public String[] tokenize(String stringWithSeparator) {
        if (hasSeparator(stringWithSeparator)) {

            return toStringWithoutSeparator(stringWithSeparator).split(getSeparator(stringWithSeparator));
        }

        return stringWithSeparator.split(",|:");
    }

    public String toStringWithoutSeparator(String stringWithSeparator) {
        if (!hasSeparator(stringWithSeparator)) {

            return stringWithSeparator;
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(stringWithSeparator);
        matcher.matches();

        return matcher.group(2);
    }

    public int[] toNumbers(String[] numberStrings) {

        return Arrays.stream(numberStrings).mapToInt(number -> {
            try {

                return Integer.parseInt(number);
            } catch (NumberFormatException e) {

                throw new NumberFormatException(number);
            }
        }).toArray();
    }

    public int compute(int[] numbers) {
        if (!isAllPositive(numbers)) {

            throw new NagativeNumberException("-1");
        }

        return Arrays.stream(numbers).sum();
    }

    private boolean isAllPositive(int[] numbers) {
        return Arrays.stream(numbers).allMatch(number -> number > 0);
    }
}
