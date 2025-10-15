import org.example.Transliterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransliteratorTest {

    @Test
    public void testBasicTransliteration() {
        assertEquals("Privet mir!", Transliterator.transliterate("Привет мир!"));

    }

    @Test
    public void testAllAlphabet() {
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                Transliterator.transliterate("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

        assertEquals("abcdefghijklmnopqrstuvwxyz",
                Transliterator.transliterate("abcdefghijklmnopqrstuvwxyz"));

        assertEquals("A B V G D E Yo Zh Z I Y K L M N O P R S T U F Kh Ts Ch Sh Shch Y  E Yu Ya",
                Transliterator.transliterate("А Б В Г Д Е Ё Ж З И Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ы Ь Э Ю Я"));

        assertEquals("a b v g d e yo zh z i y k l m n o p r s t u f kh ts ch sh shch y  e yu ya",
                Transliterator.transliterate("а б в г д е ё ж з и й к л м н о п р с т у ф х ц ч ш щ ы ь э ю я"));
    }

    @Test
    public void testCommonWords() {
        assertEquals("Rossiya", Transliterator.transliterate("Россия"));
        assertEquals("Moskva", Transliterator.transliterate("Москва"));
        assertEquals("Sankt-Peterburg", Transliterator.transliterate("Санкт-Петербург"));
        assertEquals("spasibo", Transliterator.transliterate("спасибо"));
    }

    @Test
    public void testMixedText() {
        assertEquals("Hello, mir!", Transliterator.transliterate("Hello, мир!"));
        assertEquals("Java - eto kruto!", Transliterator.transliterate("Java - это круто!"));
    }

    @Test
    public void testEmptyAndNull() {
        assertEquals("", Transliterator.transliterate(""));
        assertNull(Transliterator.transliterate(null));
    }

    @Test
    public void testSpecialCharacters() {
        assertEquals("123!@#$%", Transliterator.transliterate("123!@#$%"));
        assertEquals("Text with spaces", Transliterator.transliterate("Text with spaces"));
    }
}