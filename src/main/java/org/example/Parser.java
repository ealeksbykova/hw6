package org.example;

import java.util.*;

public class Parser {

    public static List<List <String>> parseMorseCode(String morseCode) {
        List<List <String>> message = new LinkedList<>();

        List<String> words = new ArrayList<>(Arrays.asList(morseCode.split("/")));
        for(String word : words) {
            List<String> symbols = new ArrayList<>(Arrays.asList(word.split(" ")));

            message.add(symbols);
        }

        return message;
    }

    public static List<String> parseSourceString(String latinString) {
        return new ArrayList<>(Arrays.asList(latinString.split(" ")));
    }
}
