package com.econo.lotto.domain;

import com.econo.lotto.exception.NagativeNumberException;
import com.econo.lotto.utils.CustomSplitter;
import com.econo.lotto.utils.DefaultSplitter;
import com.econo.lotto.utils.Positive;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    private StringCalculator calculator;
    private CustomSplitter customSplitter;
    private DefaultSplitter defaultSplitter;

    @Before
    public void setup() {
        calculator = new StringCalculator();
        customSplitter = new CustomSplitter();
        defaultSplitter = new DefaultSplitter();
    }

    @Test
    public void calculateTest() {
        String test = "//a\n1a2a3";
        Assertions.assertThat(calculator.calculate(test)).isEqualTo(6);
    }

    @Test
    public void getSeparatorTest() {
        String test = "//a\n1a2a3";
        Assertions.assertThat(customSplitter.getSeparator(test)).isEqualTo("a");
    }

    @Test
    public void findSeparatorTest() {
        String test = "//a\n1a2a3";
        Assertions.assertThat(defaultSplitter.supports(test)).isEqualTo(false);
    }

    @Test
    public void toStringWithoutSeparatorTest() {
        String test = "//'\n1'2'3";
        Assertions.assertThat(customSplitter.toStringWithoutSeparator(test)).isEqualTo("1'2'3");
    }

    @Test
    public void tokenizeTest() {
        String test = "//'\n1'2'3";
        String[] tokens = {"1", "2", "3"};
        Assertions.assertThat(customSplitter.split(test)).isEqualTo(tokens);
    }

    @Test
    public void toNumbersExceptionTest() {
        boolean thrown = false;
        try {
            new Positive(-1);
        } catch (NagativeNumberException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void computeTest() {
        Positive[] test = {new Positive(1), new Positive(2), new Positive(3)};
        Assertions.assertThat(calculator.add(test)).isEqualTo(6);
    }
}