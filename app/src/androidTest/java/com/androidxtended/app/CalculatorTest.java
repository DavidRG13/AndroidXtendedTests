package com.androidxtended.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAddOneAndTwo() throws Exception {
        // given
        int firstNumber = 1;
        int secondNumber = 2;

        // when
        int actual = calculator.add(firstNumber, secondNumber);

        // then
        assertEquals(3, actual);
    }
}