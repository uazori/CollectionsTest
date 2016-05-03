package ua.goit.calculator;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();


    @Test
    public void testFloat() throws Exception {
        assertEquals("5.024",calculator.calculate("f 1.0 + 4.024"));
    }

    @Test
    public void testDouble() throws Exception {
        assertEquals("112826.0",calculator.calculate("d 112414 + 412"));
    }

    @Test
    public void testInteger() throws Exception {
        assertEquals("5",calculator.calculate("i 1 + 4"));
    }

    @Test
    public void testLong() throws Exception {
        assertEquals("1266666666666666666",calculator.calculate("L 1222222222222222222 + 44444444444444444"));
    }

    @Test
    public void testNoDataType()throws Exception{
        assertEquals("error",calculator.calculate("data 1222222222222222222 + 44444444444444444"));

    }

}