package controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorControllerTest {

    CalculatorController calculatorController = new CalculatorController();

    @Test
    public void add(){
        assertEquals(6,calculatorController.add("1:2:3"));
    }

}