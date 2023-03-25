package data_strucuture_and_algorithms.sort;

import java.util.Arrays;

public class CyclicSort {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 3, 1 };
		System.out.println(Arrays.toString(cyclicSort(arr)));
	}

	private static int[] cyclicSort(int[] arr) {
		int index = 0;
		while (index < arr.length) {
			// index == value -1, then
			if (index == arr[index] - 1) {
				index++;
			} else {
				int tmp = arr[index];
				arr[index] = arr[tmp - 1];
				arr[tmp - 1] = tmp;
			}
		}
		return arr;
	}
}
