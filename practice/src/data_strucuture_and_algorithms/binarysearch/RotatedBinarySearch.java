package data_strucuture_and_algorithms.binarysearch;

public class RotatedBinarySearch {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 6, 7, 0, 1, 2 };
		int target = 7;
		System.out.println(search(arr, target));
		System.out.println(searchWithDuplicates(new int[] { 3, 3, 3, 4, 5, 6, 7, 7, 7, 7, 9, 0, 1, 2, 2 }, target));
	}

	private static int search(int[] arr, int target) {
		int pivot = findPivot(arr);

		if (pivot == -1) {
			return binarySearch(arr, target, 0, arr.length - 1);
		}

		if (arr[pivot] == target) {
			return pivot;
		}

		if (target > arr[0]) {
			return binarySearch(arr, target, 0, pivot - 1);
		}

		return binarySearch(arr, target, pivot + 1, arr.length - 1);
	}

	private static int binarySearch(int[] arr, int target, int startIndex, int endIndex) {
		while (startIndex <= endIndex) {
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

	static int findPivot(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			// case 1 : if the mid > mid + 1, it is the pivot

			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}

			// case 2 : if the mid < mid -1
			if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}

			// case 3 : if the start is greater than mid, meaning we are in decreasing
			// array, so pivot will be on left.
			if (arr[start] >= arr[mid]) {
				end = mid - 1;
			} else {
				// case 4: if the start is less the mid, meaning we are in incrasing order
				// sorted array, so pivot will be on right.
				start = mid + 1;
			}
		}
		return -1;
	}

	static int findPivotWithDuplicates(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			// case 1 : if the mid > mid + 1, it is the pivot

			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}

			// case 2 : if the mid < mid -1
			if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}

			// case 3 : if start, mid and end are equals, then ignore the duplicates but if
			// the duplicate is pivot return it.
			if (arr[mid] == arr[start] && arr[mid] == arr[end]) {

				if (arr[start] > arr[start + 1]) {
					return start;
				}
				start++;
				if (arr[end] < arr[end - 1]) {
					return end - 1;
				}
				end--;
			}

			// case 4: if start is less than or equal the mid while mid is greater than the
			// end
			if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return -1;
	}

	private static int searchWithDuplicates(int[] arr, int target) {
		int pivot = findPivotWithDuplicates(arr);

		if (pivot == -1) {
			return binarySearch(arr, target, 0, arr.length - 1);
		}

		if (arr[pivot] == target) {
			return pivot;
		}

		if (target > arr[0]) {
			return binarySearch(arr, target, 0, pivot - 1);
		}

		return binarySearch(arr, target, pivot + 1, arr.length - 1);
	}

}
