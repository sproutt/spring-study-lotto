package com.econo.lotto.controller;

import com.econo.lotto.model.Positive;
import com.econo.lotto.utils.CustomSplitter;
import com.econo.lotto.utils.DefaultSplitter;

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
        if (isDefault(input)) {
            positives = Arrays.stream(defaultSplitter.split(input)).
                    map(Positive::new).toArray(Positive[]::new);

            return add(positives);
        }
        positives = Arrays.stream(customSplitter.split(input)).
                map(Positive::new).toArray(Positive[]::new);

        return add(positives);
    }

    public boolean isDefault(String string) {
        if (defaultSplitter.supports(string)) {

            return true;
        }

        return false;
    }

    public int add(Positive[] numbers) {

        return Arrays.stream(numbers).mapToInt(Positive::getNumber).sum();
    }

}
