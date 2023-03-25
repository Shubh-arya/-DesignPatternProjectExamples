package data_strucuture_and_algorithms.linearsearch;

import java.util.Arrays;

public class SearchIn2DArray {
	public static void main(String[] args) {
		int[][] arr = { { 23, 4, 1 }, { 18, 12, 3, 9 }, { 78, 99, 34, 56 }, { 18, 12 } };
		int target = 56;
		int[] ans = search(arr, target); // format of return value {row, col}
		System.out.println(Arrays.toString(ans));

		System.out.println(max(arr));
	}

	private static int max(int[][] arr) {
		int maxValue = Integer.MIN_VALUE;
		for (int[] row : arr) {
			for (int col : row) {
				if (maxValue < col) {
					maxValue = col;
				}
			}
		}
		return maxValue;
	}

	private static int[] search(int[][] arr, int target) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if (target == arr[row][col]) {
					return new int[] { row, col };
				}
			}
		}
		return new int[] { -1, -1 };
	}
}
