package practice;

public class TowerOfHanoi {
	public static void doTowers(int n, // Number of rings to move
			int startPeg, // Peg containing rings to move
			int auxPeg, // Peg holding rings temporarily
			int endPeg) // Peg receiving rings being moved

	{
		if (n == 1) // Base case � Move one ring
			System.out.println("Move ring " + n + " from peg " + startPeg + " to peg " + endPeg);
		else {
			// Move n - 1 rings from starting peg to auxiliary peg
			doTowers(n - 1, startPeg, endPeg, auxPeg);
			// Move nth ring from starting peg to ending peg
			System.out.println("Move ring " + n + " from peg " + startPeg + " to peg " + endPeg);
			// Move n - 1 rings from auxiliary peg to ending peg
			doTowers(n - 1, auxPeg, startPeg, endPeg);
		}
	}
	
	public static void main(String[] args) {
		doTowers(2, 1, 2, 3);
	}
}
