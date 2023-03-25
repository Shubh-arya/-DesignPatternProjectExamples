package data_strucuture_and_algorithms.binarysearch;

/**
 * https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * 
 * @author sarya
 *
 */
public class InfiniteArraySearch {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int target = 10;
		System.out.println(search(arr, target));
	}

	private static int search(int[] arr, int target) {
		// first find the range
		// first start with a box of size 2
		int start = 0;
		int end = 1;

		// condition for the target to lie in the range
		while (target > arr[end]) {
			// double the box value
			// end = previous end + sizeofbox*2
			int temp = end + 1; // next start value;
			end = end + (end - start + 1) * 2;
			start = temp;
		}
		return binarySearch(arr, target, start, end);
	}

	private static int binarySearch(int[] arr, int target, int startIndex, int endIndex) {
		while (startIndex <= endIndex) {
			// find the middle element
			//int mid = (start + end) / 2; 
			// might be possible that (start + end) exceeds the range of int in java
			int midIndex = startIndex + (endIndex - startIndex) / 2;
			int midElement = arr[midIndex];
			if (target > midElement) {
				startIndex = midIndex + 1;
			} else if (target < midElement) {
				endIndex = midIndex - 1;
			} else {
				return midIndex;
			}
		}

		return -1;
	}
}
