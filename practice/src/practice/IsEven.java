package practice;

public class IsEven {
	public static void main(String[] args) {
		int n = 7;
		System.out.println(isEven(n));
	}

	private static boolean isEven(int n) {
		return (n & 1) == 0;
	}
}