package delft;

import java.util.ArrayList;
import java.util.List;

class DelftStringUtilities {

	private DelftStringUtilities() {
		// Override default constructor, to prevent it from getting considered in the
		// coverage report.
	}

	/**
	 * Searches a String for substrings delimited by a start and end tag, returning
	 * all matching substrings in an array.
	 *
	 * A null input String returns null. A null open/close
	 * returns null (no match). An empty ("") open/close returns null (no match).
	 *
	 * @param str
	 *            the String containing the substrings, null returns null, empty
	 *            returns empty
	 * @param open
	 *            the String identifying the start of the substring, empty returns
	 *            null
	 * @param close
	 *            the String identifying the end of the substring, empty returns
	 *            null
	 * @return a String Array of substrings, or null if no match
	 * @since 2.3
	 */
	public static String[] substringsBetween(final String str, final String open, final String close) {
		return null;
	}
	
}
