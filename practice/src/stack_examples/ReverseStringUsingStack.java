package stack_examples;

import java.util.Scanner;

import data_strucuture_and_algorithms.stack.ArrayBoundStack;
import data_strucuture_and_algorithms.stack.StackInterface;

public class ReverseStringUsingStack {
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);

			StackInterface<String> stringStack;
			stringStack = new ArrayBoundStack<String>(3);

			String line;

			for (int i = 1; i <= 3; i++) {
				System.out.print("Enter a line of text > ");
				line = scan.nextLine();
				stringStack.push(line);
			}

			System.out.println("\nReverse is:\n");
			while (!stringStack.isEmpty()) {
				line = stringStack.top();
				stringStack.pop();
				System.out.println(line);
			}
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
	}
}
