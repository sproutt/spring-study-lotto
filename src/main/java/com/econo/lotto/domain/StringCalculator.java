package com.econo.lotto.domain;

import com.econo.lotto.utils.CustomSplitter;
import com.econo.lotto.utils.DefaultSplitter;
import com.econo.lotto.utils.Positive;

import java.util.Arrays;


public class StringCalculator {

    Positive[] positives;

    CustomSplitter customSplitter;
    DefaultSplitter defaultSplitter;

    public StringCalculator() {
        customSplitter = new CustomSplitter();
        defaultSplitter = new DefaultSplitter();
    }

    public int calculate(String input) {
        String[] splitedInput;

        splitedInput = customSplitter.split(input);
        if (isDefault(input)) {
            splitedInput = defaultSplitter.split(input);
        }
        positives = Arrays.stream(splitedInput)
                .map(Positive::new)
                .toArray(Positive[]::new);

        return add(positives);
    }

    public boolean isDefault(String string) {
        if (defaultSplitter.supports(string)) {
            return true;
        }
        return false;
    }

    public int add(Positive[] numbers) {
        return Arrays.stream(numbers).mapToInt(positive -> positive.getNumber()).sum();
    }

}
