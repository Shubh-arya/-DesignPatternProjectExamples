package data_strucuture_and_algorithms.linearsearch;

public class FindMin {
	public static void main(String[] args) {
		int[] arr = { 18, 12, 7, 3, 14, 28 };
		System.out.println(min(arr));
	}

	private static int min(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int num : arr) {
			if (min > num) {
				min = num;
			}
		}
		return min;
	}
}
