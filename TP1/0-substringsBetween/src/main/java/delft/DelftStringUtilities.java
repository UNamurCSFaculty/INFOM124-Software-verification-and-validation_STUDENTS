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
		if (str == null || isEmpty(open) || isEmpty(close)) {
			return null;
		}
		final int strLen = str.length();
		if (strLen == 0) {
			return new String[0];
		}
		final int closeLen = close.length();
		final int openLen = open.length();
		final List<String> list = new ArrayList<>();
		int pos = 0;
		while (pos < strLen - closeLen) {
			int start = str.indexOf(open, pos);
			if (start < 0) {
				break;
			}
			start += openLen;
			final int end = str.indexOf(close, start);
			if (end < 0) {
				break;
			}
			list.add(str.substring(start, end));
			pos = end + closeLen;
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.toArray(new String[0]);
	}

	/**
	 * Checks if a CharSequence is empty ("") or null. *
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return true if the CharSequence is empty or null
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}
	
}
