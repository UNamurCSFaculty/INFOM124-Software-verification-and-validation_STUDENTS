package delft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NumberUtils {

	private NumberUtils() {
		// Empty constructor
	}

	/**
	 * This method receives two numbers, `left` and `right`, both represented as a list of digits.
	 * It adds these numbers and returns the result also as a list of digits.
	 *
	 * For example, if you want to add the numbers 23 and 42, you would need to create
	 * a (left) list with two elements [2,3] and a (right) list with two elements [4,2].
	 * 23+42 = 65, so the program would produce another list with two elements [6,5]
	 *
	 * [2,3] + [4,2] = [6,5]
	 *
	 * Each element in the left and right lists should be a number from [0-9].
	 * An IllegalArgumentException is thrown in case this pre-condition does not hold.
	 *
	 * @param left  a list containing the left number. Null returns null, empty means 0.
	 * @param right a list containing the right number. Null returns null, empty means 0.
	 * @return the sum of left and right, as a list
	 */
	public static List<Integer> add(List<Integer> left, List<Integer> right) {
		return null;
	}
}
