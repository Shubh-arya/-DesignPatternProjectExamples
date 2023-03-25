package practice;

public class BinarySearchRecursion {

	static int[] values = { 1, 2, 3, 4, 5, 6, 8, 9 };

	public static void main(String[] args) {
		System.out.println(search(0, 0, 7));
	}

	public static boolean search(int target, int first, int last) {
		int midIndex = (first + last) / 2;

		// base-case
		if (first > last) {
			return false;
		} else if (target == values[midIndex])
			return true;

		// general-case
		int midValue = values[midIndex];
		if (target > midValue) {
			last = midIndex - 1;
		} else {
			first = midIndex + 1;
		}
		search(target, first, last);
		return false;
	}
}
