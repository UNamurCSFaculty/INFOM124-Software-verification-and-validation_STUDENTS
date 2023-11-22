package delft;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

// assert array equals

class DelftStringUtilitiesTest {
    @Test
    void FirstTest() {
        // Arange
        final String[] expected = new String[] { "bc" };
        String str = "abcd";
        String open = "a";
        String close = "d";

        // Assert
        final String[] result = DelftStringUtilities.substringsBetween(str, open, close);
        // String[] result =

        // Act
        assertArrayEquals(expected, result);
    }

    @Test
    void T1() {
        assertArrayEquals(null, DelftStringUtilities.substringsBetween(null, "a", "b"));
    }
    @Test
    void T2() {
        assertArrayEquals(new String[] { }, DelftStringUtilities.substringsBetween("", "a", "b"));
    }

    @Test
    void T3() {
        assertArrayEquals(null, DelftStringUtilities.substringsBetween("abc", null, "b"));
    }

    @Test
    void T4() {
        assertArrayEquals(null, DelftStringUtilities.substringsBetween("abc", "", "b"));
    }

    @Test
    void T5() {
        assertArrayEquals(null, DelftStringUtilities.substringsBetween("abc", "a", null));
    }

    @Test
    void T6() {
        assertArrayEquals(null, DelftStringUtilities.substringsBetween("abc", "a", ""));
    }

    @Test
    void T7() {
        assertArrayEquals(null, DelftStringUtilities.substringsBetween("a", "a", "b"));
    }
}
