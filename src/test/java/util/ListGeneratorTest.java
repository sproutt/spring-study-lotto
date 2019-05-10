package util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListGeneratorTest {

    @Test
    public void getListTest(){
        assertEquals(5, ListGenerator.getNumberList(5).size());
    }
}