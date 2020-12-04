package com.incubyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void emptyString() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(0, calculator.Add(""));
    }

    @Test
    void oneNumberString() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(5, calculator.Add("5"));
    }

    @Test
    void twoNumberString() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(6, calculator.Add("1,5"));
    }

    @Test
    void unknownAmountOfNumbers() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(10, calculator.Add("1,2,3,4"));
    }

    @Test
    void newLineDelimiterAllowed() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(6, calculator.Add("1\n2,3"));
    }

    @Test
    void differentDefaultDelimiter() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(6, calculator.Add("//;\n1;2\n3"));
    }
}
