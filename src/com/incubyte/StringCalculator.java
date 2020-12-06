package com.incubyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class StringCalculator {
    private int addCount = 0;
    public int Add(String number) {
        addCount++;
        if (number.equals("")) {
            return 0;
        } else {
            String def_delimiter;
            if (!number.startsWith("//")){
                def_delimiter = ",";
            } else {
                String[] delim_arr = number.split("\n", 2);
                delim_arr[0] = delim_arr[0].replace("//","");
                String[] multi_delim = delim_arr[0].split("]\\[");
                def_delimiter = String.join("|", multi_delim);
                def_delimiter = def_delimiter.replaceAll("\\[(.*?)]", "$1");
                def_delimiter = def_delimiter.replace("$", "n"); // $ is end on line in regex. Special case.
                number = delim_arr[1];
                number = number.replace("$", "n");
            }
            String[] num_s;
            try {
                num_s = number.split(def_delimiter + "|\n");
            } catch (PatternSyntaxException e) {
                char to_replace = def_delimiter.charAt(e.getIndex());
                def_delimiter = def_delimiter.replace(to_replace, 'o');
                number = number.replace(to_replace, 'o');
                num_s = number.split(def_delimiter + "|\n");
            }
            if (num_s.length == 1) {
                int parsed_int = Integer.parseInt(num_s[0]);
                if ( parsed_int < 0){
                    throw new IllegalArgumentException("negatives not allowed, passed " + parsed_int);
                } else {
                    if (parsed_int > 1000) {
                        return 0;
                    } else return parsed_int;
                }
            } else {
                int[] num_arr = new int[num_s.length];
                List<Integer> negatives = new ArrayList<>();
                for (int x=0; x< num_s.length; x++){
                    int parsed_int = Integer.parseInt(num_s[x]);
                    if (Integer.parseInt(num_s[x]) < 0){
                        negatives.add(parsed_int);
                    } else {
                        if (parsed_int > 1000){
                            num_arr[x] = 0;
                        } else num_arr[x] = parsed_int;
                    }
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
        return addCount;
    }
}
