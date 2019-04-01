package calculator;

import utils.StringUtils;

import java.util.Arrays;

public class StringAddCalculator {

    public boolean isNull(String input) {
        if (input == null) {
            return true;
        }
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    public int addNumbers(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(number->StringUtils.parseInt(number)).sum();
    }

    public int add(String input) {
        if (isNull(input)) {
            return 0;
        }
        return addNumbers(StringUtils.splitString(input));
    }

}