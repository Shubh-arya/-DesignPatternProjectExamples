package data_strucuture_and_algorithms.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {  4, 5, 6,1, 2, 3 };
		System.out.println(Arrays.toString(selectionSortWithMin(arr)));
		System.out.println(Arrays.toString(selectionSortWithMax(arr)));

	}

	static int[] selectionSortWithMax(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int last = arr.length - i - 1;
			int maxIndex = findMaxIndex(arr, 0, last);
			int temp = arr[last];
			arr[last] = arr[maxIndex];
			arr[maxIndex] = temp;
		}

		return arr;
	}

	private static int findMaxIndex(int[] arr, int start, int end) {
		int max = start;
		while (start <= end) {
			if (arr[start] > arr[max]) {
				max = start;
			}
			start++;
		}
		return max;
	}
	
	static int[] selectionSortWithMin(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int first = i;
			int minIndex = findMinIndex(arr, i, arr.length -1);
			int temp = arr[first];
			arr[first] = arr[minIndex];
			arr[minIndex] = temp;
		}

		return arr;
	}

	private static int findMinIndex(int[] arr, int start, int end) {
		int min = start;
		while (start <= end) {
			if (arr[start] < arr[min]) {
				min = start;
			}
			start++;
		}
		return min;
	}
}
