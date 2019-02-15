package utils;

import model.Splitter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class StringUtilsTest {

    StringUtils stringUtils;
    List<Splitter> testSplitters = new ArrayList<Splitter>();

    @Before
    public void setting() {
        stringUtils = new StringUtils();
        testSplitters.add(new Splitter(','));
        testSplitters.add(new Splitter(':'));
    }

    @Test()
    public void isNULLFunction() {
        assertEquals(true, stringUtils.isNULLFunction(""));
    }

    @Test
    public void makeSplitString() {
        assertEquals(",|:", stringUtils.makeSplitString(testSplitters));
    }

    @Test
    public void stringSplitter() {
        String[] answer = new String[3];
        answer[0] = "1";
        answer[1] = "2";
        answer[2] = "3";
        assertArrayEquals(answer, stringUtils.stringSplitter("1:2:3", testSplitters));
    }

    @Test(expected = RuntimeException.class)
    public void parseInt() throws Exception {
        stringUtils.parseInt("-10");
    }

    @Test(expected = RuntimeException.class)
    public void numberChecker() throws Exception {
        stringUtils.numberChecker("-");
    }

    @Test(expected = RuntimeException.class)
    public void numbersChecker() throws Exception {
        String[] answer = new String[1];
        answer[0] = "-";
        stringUtils.numbersChecker(answer);
    }
}