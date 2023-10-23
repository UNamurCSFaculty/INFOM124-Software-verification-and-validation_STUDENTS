package delft;

import static delft.DelftStringUtilities.substringsBetween;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class DelftStringUtilitiesTest {
	@Test
	void strIsNullOrEmpty() {
		assertThat(substringsBetween(null, "a", "b")).isNull();
		assertThat(substringsBetween("", "a", "b")).isEqualTo(new String[]{});
	}

	@Test
	void openIsNullOrEmpty() {
		assertThat(substringsBetween("abd", null, "c")).isNull();
		assertThat(substringsBetween("abc", "", "b")).isNull();
	}

	@Test
	void closeIsNullOrEmpty() {
		assertThat(substringsBetween("abc", "a", null)).isEqualTo(null);
		assertThat(substringsBetween("abc", "a", null)).isEqualTo(null);
	}

	@Test
	void strOfLength1() {
		assertThat(substringsBetween("a", "a", "b")).isEqualTo(null);
		assertThat(substringsBetween("a", "b", "a")).isEqualTo(null);
		assertThat(substringsBetween("a", "b", "b")).isEqualTo(null);
		assertThat(substringsBetween("a", "a", "a")).isEqualTo(null);
	}

	@Test
	void openAndCloseOfLength1() {
		assertThat(substringsBetween("abc", "x", "y")).isEqualTo(null);
		assertThat(substringsBetween("abc", "a", "y")).isEqualTo(null);
		assertThat(substringsBetween("abc", "x", "c")).isEqualTo(null);
		assertThat(substringsBetween("abc", "a", "c")).isEqualTo(new String[] {"b"});
		assertThat(substringsBetween("abcabc", "a", "c")).isEqualTo(new String[] {"b", "b"});
		assertThat(substringsBetween("abcabyt byrc", "a", "c")).isEqualTo(new String[] {"b", "byt byr"});
	}

	@Test
	void openAndCloseTagsOfDifferentSizes() {
		assertThat(substringsBetween("aabcc", "xx", "yy")).isEqualTo(null);
		assertThat(substringsBetween("aabcc", "aa", "yy")).isEqualTo(null);
		assertThat(substringsBetween("aabcc", "xx", "cc")).isEqualTo(null);
		assertThat(substringsBetween("aabbcc", "aa", "cc")).isEqualTo(new String[] {"bb"});
		assertThat(substringsBetween("aabbccaaeecc", "aa", "cc")).isEqualTo(new String[] {"bb", "ee"});
		assertThat(substringsBetween("a abb ddc ca abbcc", "a a", "c c")).isEqualTo(new String[] {"bb dd"});
	}

	@Test
	void noSubstringBetweenOpenAndCloseTags() {
		assertThat(substringsBetween("aabb", "aa", "bb")).isEqualTo(new String[] {""});
	}

	@Test
	void closeTagAppearingMultipleTimes() {
		assertThat(substringsBetween("aabcddaabeddaab", "aa", "d")).isEqualTo(new String[] {"bc", "be"});
		assertThat(substringsBetween("aabcddabeddaab", "aa", "d")).isEqualTo(new String[] {"bc"});
	}
}
