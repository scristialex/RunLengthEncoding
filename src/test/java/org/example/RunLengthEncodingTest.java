package org.example;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunLengthEncodingTest {
    @Test
    void testNullInput() {
        assertEquals("Invalid input", RunLengthEncoding.encode(null));
    }

    @Test
    void testEmptyString() {
        char[] input = "".toCharArray();
        assertEquals("", RunLengthEncoding.encode(input));
    }

    @Test
    void testNullString() {
        char[] input = "null".toCharArray();
        assertEquals("n1u1l2", RunLengthEncoding.encode(input));
    }

    @Test
    public void testBasicCase() {
        char[] input = "aaaabbbccc".toCharArray();
        assertEquals("a4b3c3", RunLengthEncoding.encode(input));
    }

    @Test
    public void testMixedCharacters() {
        char[] input = "abbbcdddd".toCharArray();
        assertEquals("a1b3c1d4", RunLengthEncoding.encode(input));
    }

    @Test
    public void testSingleCharacter() {
        char[] input = "a".toCharArray();
        assertEquals("a1", RunLengthEncoding.encode(input));
    }

    @Test
    void testStringWithSpaces() {
        char[] input = "aa bb".toCharArray();
        assertEquals("a2 1b2", RunLengthEncoding.encode(input));
    }

    @Test
    void testSpecialCharacters() {
        char[] input = "@@@###".toCharArray();
        assertEquals("@3#3", RunLengthEncoding.encode(input));
    }

    @Test
    void testCaseSensitivity() {
        char[] input = "aaAA".toCharArray();
        assertEquals("a2A2", RunLengthEncoding.encode(input));
    }

    @Test
    void testNumericCharacters() {
        char[] input = "111223".toCharArray();
        assertEquals("132231", RunLengthEncoding.encode(input));
    }

    @Test
    void testNumericCharactersAlternated() {
        char[] input = "333111444422".toCharArray();
        assertEquals("33134422", RunLengthEncoding.encode(input));
    }

    @Test
    void testUnicodeCharacters() {
        char[] input = "¼¾¼¼¼¼ÈÈÈ".toCharArray();
        assertEquals("¼1¾1¼4È3", RunLengthEncoding.encode(input));
    }

    StringBuffer createStringBuffer (StringBuffer sb, Character c, Integer count) {
        int i = 0;
        while (i < count) {
            sb.append(c);
            i++;
        }
        return sb;
    }

    @Test
    void testBigInput() {
        StringBuffer sb = new StringBuffer();
        sb = createStringBuffer(sb, 'b', 30000);
        sb = createStringBuffer(sb, 'A', 2222);
        sb = createStringBuffer(sb, '[', 44444);
        sb = createStringBuffer(sb, '(', 55555);
        sb = createStringBuffer(sb, 'b', 10);

        char[] input = sb.toString().toCharArray();
        assertEquals("b30000A2222[44444(55555b10", RunLengthEncoding.encode(input));
    }

    @Test
    void testSampleString() {
        char[] input = "wwwwaaadexxxxxx".toCharArray();
        assertEquals("w4a3d1e1x6", RunLengthEncoding.encode(input));
    }

}
