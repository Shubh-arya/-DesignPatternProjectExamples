package data_strucuture_and_algorithms.binarysearch;

public class FirstAndLastPositionOfInteger {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 6, 6, 6, 6, 7, 8, 9, 9, 17 };
		int target = 9;
		int firstIndex = search(arr, target, true);
		int endIndex = search(arr, target, false);

		System.out.println("start and end indexes are:" + firstIndex + "   " + endIndex);
	}

	private static int search(int[] arr, int target, boolean isFirst) {
		int rs = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			} else {
				rs = mid;
				if (isFirst) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return rs;
	}
}
