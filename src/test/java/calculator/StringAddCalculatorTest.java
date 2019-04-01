package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @Before
    public void setup() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    public void isNullTest() {
        assertEquals(true, stringAddCalculator.isNull(null));
    }

    @Test
    public void addNumbersTest() {
        String[] testSet = new String[]{"1", "2", "3"};
        assertEquals(6, stringAddCalculator.addNumbers(testSet));
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, stringAddCalculator.add(null));
        assertEquals(0, stringAddCalculator.add(""));
    }

    @Test
    public void add_숫자하나() throws Exception {
        assertEquals(1, stringAddCalculator.add("1"));
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        assertEquals(3, stringAddCalculator.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        assertEquals(6, stringAddCalculator.add("1,2:3"));
    }

    @Test
    public void add_custom_구분자() throws Exception {
        assertEquals(6, stringAddCalculator.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception {
        stringAddCalculator.add("-1,2,3");
    }
}