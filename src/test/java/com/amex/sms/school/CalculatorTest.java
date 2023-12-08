package com.amex.sms.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mayukha
 * Created on 07 Nov, 2023
 * @project school
 */
class CalculatorTest {



    @Test
    void addTestPositivePositive() {
        Calculator cal = new Calculator();
        int a = 5, b = 5;
        int c= cal.add(a,b);

        assertEquals(10,c);
    }

    @Test
    void addTestPositiveNegative() {
        Calculator cal = new Calculator();
        int a = 5, b = -5;
        int c= cal.add(a,b);

        assertEquals(10,c,"Addition is based on absolute values");
    }
    @Test
    void addTestNegativePositive() {
        Calculator cal = new Calculator();
        int a = -5, b = 5;
        int c= cal.add(a,b);

        assertEquals(10,c,"Addition is based on absolute values");
    }
    @Test
    void addTestNegativeNegative() {
        Calculator cal = new Calculator();
        int a = -5, b = -5;
        int c= cal.add(a,b);

        assertEquals(10,c,"Addition is based on absolute values");
    }

    @Test
    void subTestAGreaterThanB() {
        Calculator cal = new Calculator();
        int a = 6, b = 1;
        int c= cal.sub(a,b);
        assertEquals(5,c);

    }

    @Test
    void subTestALessThanB() {
        Calculator cal = new Calculator();
        int a = 2, b = 8;
        Exception ex = assertThrows(RuntimeException.class, ()->{cal.sub(a,b);});

        assertEquals("a cannot be less than b", ex.getMessage(),"a should be greater than b");

    }

    @Test
    void subTestAEqualsB() {
        Calculator cal = new Calculator();
        int a = -2, b = -2;
        int c= a-b;
        assertEquals(0,c);

    }


    @Test
    void productTestPositivePositive() {
        Calculator cal = new Calculator();
        int a = 5, b = 5;
        int c= cal.product(a,b);

        assertEquals(25,c);

    }
    @Test
    void productTestNegativePositive() {
        Calculator cal = new Calculator();
        int a = 5, b = -5;
        int c= cal.product(a,b);

        assertEquals(25,c,"Multiplication is based on absolute values");

    }

   @Test
   void divideTestPositivePositive() {
        Calculator cal = new Calculator();
        int a = 5, b = 5;
        double c= cal.divide(a,b);

        assertEquals(1,c);

    }

    @Test
    void divideTestNegativePositive() {
        Calculator cal = new Calculator();
        int a = -5, b = 5;
        Exception ex = assertThrows(RuntimeException.class, ()->{cal.divide(a,b);});

        assertEquals("a cannot be less than b", ex.getMessage(),"a should be greater than b");

    }

    @Test
    void divideTestPositiveNegative() {
        Calculator cal = new Calculator();
        int a = 5, b = -5;
        double c= cal.divide(a,b);

        assertEquals(-1, c);

    }

    @Test
    void divideTestBEquals0() {
        Calculator cal = new Calculator();
        int a = 5, b = 0;
        Exception ex = assertThrows(RuntimeException.class, ()->{cal.divide(a,b);});

        assertEquals("Cannot divide by 0", ex.getMessage(),"b should be greater than 0" );

    }

    /*@Test
    public void testAddMax(){

        Calculator cal = new Calculator();
        int a= Integer.MAX_VALUE;
        int b= Integer.MAX_VALUE;
        int c = cal.add(a,b);
        assertEquals(Integer.MAX_VALUE, c);

    }*/

}