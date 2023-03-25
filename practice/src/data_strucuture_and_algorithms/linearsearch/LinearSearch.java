package data_strucuture_and_algorithms.linearsearch;

public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 4, 5, 7, 8, 3 };
		int target = 0;
		boolean result = search(arr, target);
		System.out.println("result : " + result);
	}

	private static boolean search(int[] arr, int target) {
		for (int num : arr) {
			if (target == num) {
				return true;
			}
		}
		return false;
	}
}
