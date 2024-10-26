package org.example;


import static org.example.Parser.parseMorseCode;
import static org.example.Parser.parseSourceString;
import static org.example.Translator.toLatinTranslation;
import static org.example.Translator.toMorseTranslation;
import static org.example.Validator.*;

public class HomeWork implements MorseTranslator {

    /**
     * <h1>Задание 1.</h1>
     * Требуется реализовать интерфейс MorseTranslator в соответствии с JavaDoc описанием.
     */
    public MorseTranslator morseTranslator() {
        return null;
    }

    @Override
    public String decode(String morseCode) {
        if (!morseCodeValidation(morseCode)) {
            throw new InvalidCharacterException("Invalid morse code: " + morseCode);
        }

        return toLatinTranslation(parseMorseCode(morseCode));
    }

    @Override
    public String encode(String source) {
        if (!sourceValidation(source)) {
            throw new InvalidCharacterException("Invalid source string: " + source);
        }

        return toMorseTranslation(parseSourceString(source));
    }
}
