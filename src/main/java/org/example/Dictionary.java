package org.example;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Dictionary {

    private final Map<String, Character> morseToLatin;
    private final Map<Character, String> latinToMorse;

    public Dictionary() {
        this.morseToLatin = new HashMap<>();
        this.latinToMorse = new HashMap<>();

        generateMorseToLatin();
        generateLatinToMorse();
    }

    private void generateMorseToLatin() {
        morseToLatin.put(".-", 'a');
        morseToLatin.put("-...", 'b');
        morseToLatin.put("-.-.", 'c');
        morseToLatin.put("-..", 'd');
        morseToLatin.put(".", 'e');
        morseToLatin.put("..-.", 'f');
        morseToLatin.put("--.", 'g');
        morseToLatin.put("....", 'h');
        morseToLatin.put("..", 'i');
        morseToLatin.put(".---", 'j');
        morseToLatin.put("-.-", 'k');
        morseToLatin.put(".-..", 'l');
        morseToLatin.put("--", 'm');
        morseToLatin.put("-.", 'n');
        morseToLatin.put("---", 'o');
        morseToLatin.put(".--.", 'p');
        morseToLatin.put("--.-", 'q');
        morseToLatin.put(".-.", 'r');
        morseToLatin.put("...", 's');
        morseToLatin.put("-", 't');
        morseToLatin.put("..-", 'u');
        morseToLatin.put("...-", 'v');
        morseToLatin.put(".--", 'w');
        morseToLatin.put("-..-", 'x');
        morseToLatin.put("-.--", 'y');
        morseToLatin.put("--..", 'z');
        morseToLatin.put(".----", '1');
        morseToLatin.put("..---", '2');
        morseToLatin.put("...--", '3');
        morseToLatin.put("....-", '4');
        morseToLatin.put(".....", '5');
        morseToLatin.put("-....", '6');
        morseToLatin.put("--...", '7');
        morseToLatin.put("---..", '8');
        morseToLatin.put("----.", '9');
        morseToLatin.put("-----", '0');
    }

    private void generateLatinToMorse() {
        latinToMorse.put('a', ".-" );
        latinToMorse.put('b', "-...");
        latinToMorse.put('c', "-.-.");
        latinToMorse.put('d', "-..");
        latinToMorse.put('e', ".");
        latinToMorse.put('f', "..-.");
        latinToMorse.put('g', "--.");
        latinToMorse.put('h', "....");
        latinToMorse.put('i', "..");
        latinToMorse.put('j', ".---");
        latinToMorse.put('k', "-.-");
        latinToMorse.put('l', ".-..");
        latinToMorse.put('m', "--");
        latinToMorse.put('n', "-.");
        latinToMorse.put('o', "---");
        latinToMorse.put('p', ".--.");
        latinToMorse.put('q', "--.-");
        latinToMorse.put('r', ".-.");
        latinToMorse.put('s', "...");
        latinToMorse.put('t', "-");
        latinToMorse.put('u', "..-");
        latinToMorse.put('v', "...-");
        latinToMorse.put('w', ".--");
        latinToMorse.put('x', "-..-");
        latinToMorse.put('y', "-.--");
        latinToMorse.put('z', "--..");
        latinToMorse.put('1', ".----");
        latinToMorse.put('2', "..---");
        latinToMorse.put('3', "...--");
        latinToMorse.put('4', "....-");
        latinToMorse.put('5', ".....");
        latinToMorse.put('6', "-....");
        latinToMorse.put('7', "--...");
        latinToMorse.put('8', "---..");
        latinToMorse.put('9', "----.");
        latinToMorse.put('0', "-----");
    }
}
