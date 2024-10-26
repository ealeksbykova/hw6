package org.example;

public class Validator {
    public static boolean morseCodeValidation(String morseCode) {
        for (char c : morseCode.toCharArray()) {
            if (c != '-' && c != '.' && c != '/' && c != ' ') {
                return false;
            }
        }

        return true;
    }

    public static boolean sourceValidation(String source) {
        for (char c : source.toLowerCase().toCharArray()) {
            if (!((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) && !(c == ' ')) {
                return false;
            }
        }

        return true;
    }
}
