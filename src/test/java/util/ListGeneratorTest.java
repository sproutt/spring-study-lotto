package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListGeneratorTest {

    @Test
    public void getListTest(){
        assertEquals(5, ListGenerator.getNumbersInRange(5).size());
    }
}