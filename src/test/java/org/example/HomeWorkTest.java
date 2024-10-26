package org.example;

import org.junit.Test;

import java.util.List;

import static org.example.Parser.parseMorseCode;
import static org.example.Parser.parseSourceString;
import static org.example.Translator.toLatinTranslation;
import static org.example.Translator.toMorseTranslation;
import static org.example.Validator.morseCodeValidation;
import static org.example.Validator.sourceValidation;
import static org.junit.jupiter.api.Assertions.*;


public class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    public void decodeSuccessTest() {
        assertAll(
            () -> assertEquals("hello world", homeWork.decode(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ")),
            () -> assertEquals(
                "Look at my horse my horse is amazing 11111".toLowerCase(),
                homeWork.decode(".-.. --- --- -.- / .- - / -- -.-- / .... --- .-. ... . / -- -.-- / .... --- .-. ... . / .. ... / .- -- .- --.. .. -. --. / .---- .---- .---- .---- .---- ")
            )
        );
    }

    @Test
    public void decodeInvalidMorseCodeFailTest() {
        String message = ",om kjnf !!!";

        InvalidCharacterException exception = assertThrows(
                InvalidCharacterException.class, () -> homeWork.decode(message)
        );

        assertEquals("Invalid morse code: " + message, exception.getMessage());
    }

    @Test
    public void encodeSuccessTest() {
        assertAll(
            () -> assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ", homeWork.encode("hello world")),
            () -> assertEquals(".---- ..--- ...-- ....- ..... -.... --... / ----. ---.. --... -.... ..... ....- ...-- ", homeWork.encode("1234567 9876543"))
        );
    }

    @Test
    public void encodeFailTest() {
        String message = ".. -- / ..,";

        InvalidCharacterException exception = assertThrows(
                InvalidCharacterException.class, () -> homeWork.encode(message)
        );

        assertEquals("Invalid source string: " + message, exception.getMessage());
    }

    @Test
    public void morseCodeValidationSuccessTest() {
        assertAll(
            () -> assertTrue(morseCodeValidation("./- ")),
            () -> assertTrue(morseCodeValidation(""))
        );
    }

    @Test
    public void morseCodeValidationFailTest() {
        assertAll (
            () -> assertFalse(morseCodeValidation("./- ,")),
            () -> assertFalse(morseCodeValidation("wafaf4354325"))
        );
    }

    @Test
    public void sourceValidationSuccessTest() {
        assertAll(
            () -> assertTrue(sourceValidation("4 Valid       7 String10   ")),
            () -> assertTrue(sourceValidation(""))
        );
    }

    @Test
    public void sourceValidationFailTest() {
        assertAll(
            () ->assertFalse(morseCodeValidation("dfsldkj, lkjf")),
            () -> assertFalse(morseCodeValidation("wafaf4354325"))
        );
    }

    @Test
    public void parseMorseCodeSuccessTest() {
        List<List<String>> words = parseMorseCode(".- --../--. --. -.- .-.-");
        assertEquals("--..", words.iterator().next().get(1));
    }

    @Test
    public void parseSourceStringSuccessTest() {
        List<String> words = parseSourceString("hello world 1 2 3");
        assertEquals("world", words.get(1));
    }

    @Test
    public void toLatinTranslationSuccessTest() {
        List<List<String>> hello = List.of(List.of("....", ".", ".-..", ".-..", "---"), List.of(".--", "---", ".-.", ".-..", "-.."));
        List<List<String>> sosSignal = List.of(List.of("...", "---", "..."));

        assertAll(
            () -> assertEquals("hello world", toLatinTranslation(hello)),
            () -> assertEquals("sos", toLatinTranslation(sosSignal))
        );
    }

    @Test
    public void toMorseTranslationSuccessTest() {
        List<String> hello = List.of("hello", "world");
        List<String> springBoot = List.of("SpringBoot", "4ever");

        assertAll(
            () -> assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ", toMorseTranslation(hello)),
            () -> assertEquals("... .--. .-. .. -. --. -... --- --- - / ....- . ...- . .-. ", toMorseTranslation(springBoot))
        );
    }

    @Test
    public void morseCodeValidationInvalidSymbolFailTest() {
        List<List<String>> message = List.of(List.of("--..-----", "---.."));

        InvalidCharacterException exception = assertThrows(
                InvalidCharacterException.class, () -> toLatinTranslation(message)
        );

        assertEquals("Invalid morse symbol: " + message.iterator().next().get(0), exception.getMessage());
    }
}