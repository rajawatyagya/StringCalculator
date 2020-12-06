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

    @Test
    void negativeNumberNotAllowed() {
        StringCalculator calculator = new StringCalculator();
        Throwable thrown =  Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.Add("-1,2\n3"));
        Assertions.assertEquals("negatives not allowed, passed [-1]", thrown.getMessage());
    }

    @Test
    void multipleNegativeNumber() {
        StringCalculator calculator = new StringCalculator();
        Throwable thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.Add("-2,-3\n4"));
        Assertions.assertEquals("negatives not allowed, passed [-2, -3]", thrown.getMessage());
    }

    @Test
    void getCalledCountForAdd() {
        StringCalculator calculator = new StringCalculator();
        calculator.Add("");
        calculator.Add("1");
        calculator.Add("1,2");
        calculator.Add("1,2,4");
        Assertions.assertEquals(4, calculator.GetCalledCount());
    }

    @Test
    void numberBiggerThanThousand() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(3, calculator.Add("3,1001"));
    }

    @Test
    void anyLengthDelimiter() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(5, calculator.Add("//[***]\n1***2***2"));
    }

     @Test
    void multipleDelimitersProvided() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(6, calculator.Add("//[*][#]\n1*2#3"));
     }
}
