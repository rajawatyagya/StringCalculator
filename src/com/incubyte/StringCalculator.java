package com.incubyte;

public class StringCalculator {
    public int Add(String number) {
        if (number.equals("")) {
            return 0;
        } else {
            return Integer.parseInt(number);
        }
    }
}
