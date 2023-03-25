package practice;

public class FindUnique {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 4, 5, 2, 4, 5, 6, 3, 3 };
		System.out.println(findUnique(nums));
	}

	private static int findUnique(int[] nums) {
		int unique = 0;
		for (int n : nums) {
			unique ^= n;
		}
		return unique;
	}
}