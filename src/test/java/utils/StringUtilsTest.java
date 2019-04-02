package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void splitString() {
        String[] testResult = new String[]{"1","2","3"};
        assertArrayEquals(testResult,StringUtils.splitString("1,2,3"));
    }

    @Test
    public void parseInt() {
        assertEquals(1,StringUtils.parseInt("1"));
    }
}