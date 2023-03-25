package data_strucuture_and_algorithms.binarysearch;

/**
 * Steps: 1. Find the peak index. 2. try to find in the first half for asc
 * array. 3. If not found, try to find in the second half of the array in desc
 * order.
 * 
 * @author sarya
 *
 */
public class SearchInMountainArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 7, 6, 4, 2, 1 };
		int target = 7;
		int targetIndex = searchMountainArray(arr, target);
		System.out.println(targetIndex);
	}

	private static int searchMountainArray(int[] arr, int target) {
		int peakIndex = peakIndex(arr);
		if (arr[peakIndex] == target) {
			return peakIndex;
		}
		int result = orderAgnosticBS(arr, target, 0, peakIndex);
		if (result == -1) {
			result = orderAgnosticBS(arr, target, peakIndex + 1, arr.length - 1);
		}
		return result;
	}

	private static int peakIndex(int[] mArray) {
		int s = 0;
		int e = mArray.length - 1;
		while (s < e) {
			int m = s + (e - s) / 2;
			if (mArray[m] > mArray[m + 1]) {
				// Meaning you in the descreasing part of the array
				e = m;
			} else {
				// Meaning you are in the increasing part of the array
				s = m + 1;
			}
		}
		return s;
	}

	private static int orderAgnosticBS(int[] arr, int target, int startIndex, int endIndex) {
		boolean isDescOrder = false;
		if (arr[startIndex] > arr[endIndex]) {
			isDescOrder = true;
		}

		while (startIndex <= endIndex) {
			int midIndex = startIndex + (endIndex - startIndex) / 2;
			int midElement = arr[midIndex];

			if (target == midElement) {
				return midIndex;
			}

			if (isDescOrder) {
				if (target < midElement) {
					startIndex = midIndex + 1;
				} else if (target > midElement) {
					endIndex = midIndex - 1;
				}
			} else {
				if (target > midElement) {
					startIndex = midIndex + 1;
				} else if (target < midElement) {
					endIndex = midIndex - 1;
				}
			}
		}

		return -1;
	}

}
