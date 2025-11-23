package org.example;

import java.util.*;

public class RunLengthEncoding {
    public static String encode (char[] input) {
        if (input == null) {
            return "Invalid input";
        } else if (input.length == 0) {
            return "";
        }

        int inputLength = input.length;
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;
        for (i = 0; i < inputLength; i = j) {
            int count = 1;
            for (j = i + 1; j < inputLength; j++) {
                if (input[i] == input[j]) {
                   count++;
                } else {
                    break;
                }
            }
            result.append(input[i]);
            result.append(count);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println(encode(args[0].toCharArray()));
        } else if (args.length == 0){
            System.out.println("Please provide an argument");
        } else {
            System.out.println("Please provide only one argument");
        }
    }
}
