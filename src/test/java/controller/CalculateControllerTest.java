package controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateControllerTest {

    private CalculateController calculateController;

    @Before
    public void setting(){
        calculateController = new CalculateController();
    }

    @Test
    public void splitString() {
        String[] result = new String[]{"1","2","3"};
        assertArrayEquals(result,calculateController.splitString("//;\n1;2;3"));
    }

    @Test
    public void add() {
        assertEquals(6,calculateController.add("//;\n1;2;3"));
    }
}