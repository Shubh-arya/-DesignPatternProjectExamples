package data_strucuture_and_algorithms.linearsearch;

/*
 * https://leetcode.com/problems/richest-customer-wealth/
 */
public class MaxWealth {
	public static int maximumWealth(int[][] accounts) {
		int maxWealth = Integer.MIN_VALUE;
		for (int[] account : accounts) {
			int wealth = 0;
			for (int amount : account) {
				wealth += amount;
			}
			if (maxWealth < wealth) {
				maxWealth = wealth;
			}
		}
		return maxWealth;
	}

	public static void main(String[] args) {
		int[][] accounts = { { 1, 5 }, { 7, 3 }, { 3, 5 } };
		System.out.println(maximumWealth(accounts));
	}
}
