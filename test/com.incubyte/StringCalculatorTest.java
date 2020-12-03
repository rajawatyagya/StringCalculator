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
}
