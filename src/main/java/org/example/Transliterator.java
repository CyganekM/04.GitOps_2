package org.example;

import java.util.HashMap;
import java.util.Map;

public class Transliterator {

    private static final Map<Character, String> TRANSLIT_MAP = createTranslitMap();

    private static Map<Character, String> createTranslitMap() {
        Map<Character, String> map = new HashMap<>();

        // Русский алфавит -> Латинские аналоги
        map.put('а', "a"); map.put('б', "b"); map.put('в', "v"); map.put('г', "g");
        map.put('д', "d"); map.put('е', "e"); map.put('ё', "yo"); map.put('ж', "zh");
        map.put('з', "z"); map.put('и', "i"); map.put('й', "y"); map.put('к', "k");
        map.put('л', "l"); map.put('м', "m"); map.put('н', "n"); map.put('о', "o");
        map.put('п', "p"); map.put('р', "r"); map.put('с', "s"); map.put('т', "t");
        map.put('у', "u"); map.put('ф', "f"); map.put('х', "kh"); map.put('ц', "ts");
        map.put('ч', "ch"); map.put('ш', "sh"); map.put('щ', "shch"); map.put('ъ', "");
        map.put('ы', "y"); map.put('ь', ""); map.put('э', "e"); map.put('ю', "yu");
        map.put('я', "ya");

        // Заглавные буквы
        map.put('А', "A"); map.put('Б', "B"); map.put('В', "V"); map.put('Г', "G");
        map.put('Д', "D"); map.put('Е', "E"); map.put('Ё', "Yo"); map.put('Ж', "Zh");
        map.put('З', "Z"); map.put('И', "I"); map.put('Й', "Y"); map.put('К', "K");
        map.put('Л', "L"); map.put('М', "M"); map.put('Н', "N"); map.put('О', "O");
        map.put('П', "P"); map.put('Р', "R"); map.put('С', "S"); map.put('Т', "T");
        map.put('У', "U"); map.put('Ф', "F"); map.put('Х', "Kh"); map.put('Ц', "Ts");
        map.put('Ч', "Ch"); map.put('Ш', "Sh"); map.put('Щ', "Shch"); map.put('Ъ', "");
        map.put('Ы', "Y"); map.put('Ь', ""); map.put('Э', "E"); map.put('Ю', "Yu");
        map.put('Я', "Ya");

        return map;
    }

    public static String transliterate(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (TRANSLIT_MAP.containsKey(c)) {
                result.append(TRANSLIT_MAP.get(c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            input = args[0];

            String result = transliterate(input);
            System.out.println("Input: " + input);
            System.out.println("Output: " + result);
        } else {
            input = "DevOps - это круто!";
            String result = transliterate(input);
            System.out.println("Input: " + input);
            System.out.println("Output: " + result);
        }
    }
}