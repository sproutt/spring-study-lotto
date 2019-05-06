package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class SplitGeneratorTest {

    @Test
    public void customSplitStringTest(){
        String[] strings = {"1", "2", "3"};
        assertArrayEquals(strings, SplitGenerator.customSplitString("1,2,3", ","));
        assertArrayEquals(strings, SplitGenerator.customSplitString("1:2:3", ":"));
    }

    @Test
    public void customMixSplitStringTest(){
        String[] strings = {"1", "2", "3"};
        assertArrayEquals(strings, SplitGenerator.customSplitString("1,2:3", ",|:"));
    }
}