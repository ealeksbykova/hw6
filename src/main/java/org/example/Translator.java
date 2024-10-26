package org.example;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Translator {
    private static final Dictionary dictionary = new Dictionary();

    public static String toLatinTranslation(List<List<String>> morseCode) {
        StringBuilder translationResult = new StringBuilder();
        Map<String, Character> morseToLatinDictionary = dictionary.getMorseToLatin();

        for (List<String> words : morseCode) {
            for (String letter : words) {
                if (!Objects.equals(letter, "")) {
                    if (morseToLatinDictionary.get(letter) == null) {
                        throw new InvalidCharacterException("Invalid morse symbol: " + letter);
                    }
                    translationResult.append(morseToLatinDictionary.get(letter));
                }
            }
            translationResult.append(" ");
        }
        translationResult.deleteCharAt(translationResult.length() - 1);

        return translationResult.toString();
    }

    public static String toMorseTranslation(List<String> latinString) {
        StringBuilder result = new StringBuilder();
        Map<Character,String> latinToMorseDictionary = dictionary.getLatinToMorse();

        for (String word : latinString) {
            for (char letter : word.toLowerCase().toCharArray()) {
                result.append(latinToMorseDictionary.get(letter));
                result.append(" ");
            }
            result.append('/');
            result.append(" ");
        }
        result.delete(result.length() - 3, result.length() - 1);

        return result.toString();
    }
}
