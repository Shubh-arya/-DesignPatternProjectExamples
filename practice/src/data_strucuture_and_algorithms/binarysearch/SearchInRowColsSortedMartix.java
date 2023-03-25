package data_strucuture_and_algorithms.binarysearch;

public class SearchInRowColsSortedMartix {

	public static void main(String[] args) {
		int[][] matrix = { { 10, 20, 30, 40 }, { 11, 21, 31, 41 }, { 12, 22, 32, 42 } };
		int[] result = search(matrix, 41);
		System.out.println("target found at row:" + result[0] + " and col: " + result[1]);
	}

	static int[] search(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[row].length - 1;

		while (row < matrix.length - 1 && col >= 0) {
			if (matrix[row][col] == target) {
				return new int[] { row, col };
			}

			if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}

		}

		return new int[] { -1, -1 };
	}
}
