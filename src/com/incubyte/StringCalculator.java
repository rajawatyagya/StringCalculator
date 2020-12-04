package com.incubyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int Add(String number) {
        if (number.equals("")) {
            return 0;
        } else {
            char def_delimiter;
            if (number.charAt(0) != '/'){
                def_delimiter = ',';
            } else {
                String[] delim_arr = number.split("\n", 2);
                def_delimiter = delim_arr[0].charAt(delim_arr[0].length()-1);
                number = delim_arr[1];
            }
            String[] num_s = number.split("[" + def_delimiter + "\n]");
            if (num_s.length == 1) {
                if (Integer.parseInt(num_s[0]) < 0){
                    throw new IllegalArgumentException("negatives not allowed, passed " + Integer.parseInt(num_s[0]));
                } else return Integer.parseInt(num_s[0]);
            } else {
                int[] num_arr = new int[num_s.length];
                List<Integer> negatives = new ArrayList<>();
                for (int x=0; x< num_s.length; x++){
                    if (Integer.parseInt(num_s[x]) < 0){
                        negatives.add(Integer.parseInt(num_s[x]));
                    } else num_arr[x] = Integer.parseInt(num_s[x]);
                }
                if (negatives.isEmpty()) {
                    return Arrays.stream(num_arr).sum();
                } else {
                    throw new IllegalArgumentException("negatives not allowed, passed " + negatives.toString());
                }
            }
        }
    }

    public int GetCalledCount() {
        return 0;
    }
}
