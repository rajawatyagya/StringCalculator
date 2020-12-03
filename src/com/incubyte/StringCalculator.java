package com.incubyte;

import java.util.Arrays;

public class StringCalculator {
    public int Add(String number) {
        if (number.equals("")) {
            return 0;
        } else {
            String[] num_s = number.split(",");
            if (num_s.length == 1) {
                return Integer.parseInt(num_s[0]);
            } else {
                int[] num_arr = new int[num_s.length];
                for (int x=0; x< num_s.length; x++){
                    num_arr[x] = Integer.parseInt(num_s[x]);
                }
                return Arrays.stream(num_arr).sum();
            }

        }
    }
}
