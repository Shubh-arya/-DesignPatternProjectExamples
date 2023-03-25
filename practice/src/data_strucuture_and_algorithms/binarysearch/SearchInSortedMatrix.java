package data_strucuture_and_algorithms.binarysearch;

import java.util.Arrays;

public class SearchInSortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int target = 2;

		System.out.println(Arrays.toString(search(matrix, target)));
	}

	static int[] search(int[][] matrix, int target) {

		if (matrix.length == 1) {
			// do binary search in the first row directly.
		}

		int rStart = 0;
		int rEnd = matrix.length - 1;
		int cMid = matrix.length / 2;

		while (rStart < rEnd - 1) {
			int mid = rStart + (rEnd - rStart) / 2;

			if (matrix[mid][cMid] == target) {
				return new int[] { mid, cMid };
			}

			if (matrix[mid][cMid] < target) {
				rStart = mid + 1;
			} else {
				rEnd = mid - 1;
			}
		}

		// Now we have only two rows remaining, now search at the middle element or
		// search in the four parts remaining.

		if (matrix[rStart][cMid] == target) {
			return new int[] { rStart, cMid };
		}

		if (matrix[rStart + 1][cMid] == target) {
			return new int[] { rStart + 1, cMid };

		}

		// Search in the 1st Half
		if (target <= matrix[rStart][cMid - 1]) {
			return binarySearch(matrix, rStart, 0, cMid - 1, target);
		}

		// Search in the 2nd Half
		if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][matrix[0].length - 1]) {
			return binarySearch(matrix, rStart, cMid + 1, matrix[0].length - 1, target);
		}

		// Search in the 3rd Half
		if (target <= matrix[rStart + 1][cMid - 1]) {
			return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
		} else {
			return binarySearch(matrix, rStart + 1, cMid + 1, matrix[0].length - 1, target);
		}
	}

	static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {

		while (cStart <= cEnd) {
			int mid = cStart + (cEnd - cStart) / 2;

			if (matrix[row][mid] == target) {
				return new int[] { row, mid };
			}

			if (matrix[row][mid] < target) {
				cStart = mid + 1;
			} else {
				cEnd = mid - 1;
			}

		}

		return new int[] { -1, -1 };
	}

}
