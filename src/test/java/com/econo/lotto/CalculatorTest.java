package com.econo.lotto;

import com.econo.lotto.exception.NagativeNumberException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void calculateTest() {
        String test = "//a\n1a2a3";
        Assertions.assertThat(calculator.calculate(test)).isEqualTo(6);
        test = "1,5:3";
        Assertions.assertThat(calculator.calculate(test)).isEqualTo(9);
    }

    @Test
    public void getSeparatorTest() {
        String test = "//a\n1a2a3";
        Assertions.assertThat(calculator.getSeparator(test)).isEqualTo("a");
    }

    @Test
    public void findSeparatorTest() {
        String test = "//a\n1a2a3";
        Assertions.assertThat(calculator.hasSeparator(test)).isEqualTo(true);
    }

    @Test
    public void toStringWithoutSeparatorTest() {
        String test = "//'\n1'2'3";
        Assertions.assertThat(calculator.toStringWithoutSeparator(test)).isEqualTo("1'2'3");
    }

    @Test
    public void tokenizeTest() {
        String test = "//'\n1'2'3";
        String[] tokens = {"1", "2", "3"};
        Assertions.assertThat(calculator.tokenize(test)).isEqualTo(tokens);
    }

    @Test
    public void toNumbersTest() {
        String[] test = {"1", "2", "3"};
        int[] answer = {1, 2, 3};
        Assertions.assertThat(calculator.toNumbers(test)).isEqualTo(answer);
    }

    @Test
    public void toNumbersExceptionTest() {
        boolean thrown = false;
        String[] test = {"a", "0", "3"};
        try {
            calculator.toNumbers(test);
        } catch (NumberFormatException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void computeTest() {
        int[] test = {1, 2, 3};
        Assertions.assertThat(calculator.compute(test)).isEqualTo(6);
    }

    @Test
    public void computeExceptionTest() {
        boolean thrown = false;
        int[] test = {-1, 0, 3};
        try {
            calculator.compute(test);
        } catch (NagativeNumberException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}