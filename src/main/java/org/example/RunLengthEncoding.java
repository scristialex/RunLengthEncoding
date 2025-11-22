package org.example;

import java.util.*;

public class RunLengthEncoding {
    public static String encode (char[] input) {
        if (input == null) {
            return "Invalid input";
        } else if (input.length == 0) {
            return "";
        }

        Map<Character, Integer> occurrence = new HashMap<>();
        for (Character current : input) {
            occurrence.put(current, occurrence.getOrDefault(current, 0) + 1);
        }

        Set<Character> processedCharacters = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (!processedCharacters.contains(input[i])) {
                processedCharacters.add(input[i]);
                result.append(input[i]);
                result.append(occurrence.get(input[i]));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            int i = 0;
            while (i < args.length) {
                System.out.println(encode(args[i].toCharArray()));
                i++;
            }
        } else {
            System.out.println("Please provide an argument");
        }

    }
}
