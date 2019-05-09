package model;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @Before
    public void setup() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertThat(stringAddCalculator.calculate(null)).isEqualTo(0);
        assertThat(stringAddCalculator.calculate("")).isEqualTo(0);
        assertThat(stringAddCalculator.calculate(" ")).isEqualTo(0);

    }

    @Test
    public void add_숫자하나() throws Exception {
        assertThat(stringAddCalculator.calculate("1")).isEqualTo(1);
        assertEquals(1, stringAddCalculator.calculate("1"));
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        assertThat(stringAddCalculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        assertThat(stringAddCalculator.calculate("1,1:2")).isEqualTo(4);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        assertThat(stringAddCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception {
        stringAddCalculator.calculate("-1,2,3");
    }
}