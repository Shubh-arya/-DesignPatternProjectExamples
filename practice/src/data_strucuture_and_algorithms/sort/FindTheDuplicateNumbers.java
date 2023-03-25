package data_strucuture_and_algorithms.sort;

public class FindTheDuplicateNumbers {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 3, 4, 2, 2, 2 };
		System.out.println(findDuplicate(arr));
	}

	private static int findDuplicate(int[] arr) {
		int index = 0;
		while (index < arr.length) {
			if (arr[index] != index + 1) {
				int correct = arr[index] - 1; // assume the number @index's index is correct.
				if (arr[index] != arr[correct]) { // if not swap
					swap(arr, index, correct);
				} else {
					return arr[index];
				}
			} else {
				index++;
			}
		}
		return -1;
	}

	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}
}
