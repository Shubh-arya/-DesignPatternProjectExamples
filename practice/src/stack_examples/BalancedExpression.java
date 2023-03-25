package stack_examples;

import java.util.Scanner;

import data_strucuture_and_algorithms.stack.ArrayBoundStack;
import data_strucuture_and_algorithms.stack.LinkedStack;
import data_strucuture_and_algorithms.stack.StackInterface;
import data_strucuture_and_algorithms.stack.StackUnderflowException;

/**
 * Create a new stack of size equal to the length of expression Set
 * stillBalanced to true Get the first character from expression while (the
 * expression is still balanced AND there are still more characters to process)
 * Process the current character Get the next character from expression if
 * (!stillBalanced) return 1 else if (stack is not empty) return 2 else return 0
 *
 * if (the character is an open symbol) Push the open symbol character onto the
 * stack else if (the character is a close symbol) if (the stack is empty) Set
 * stillBalanced to false else Set open symbol character to the value at the top
 * of the stack Pop the stack if the close symbol character does not "match" the
 * open symbol character Set stillBalanced to false else Skip the character
 * 
 * @author sarya
 *
 */
public class BalancedExpression {

	private String openSet;
	private String closeSet;

	BalancedExpression(String openSet, String closeSet) {
		this.openSet = openSet;
		this.closeSet = closeSet;
	}

	int test(String expression) {
		boolean isBalanced = true;
//		StackInterface<Integer> stack = new ArrayBoundStack<Integer>(expression.length());
		StackInterface<Integer> stack = new LinkedStack<Integer>();
		int currenCharIndex = 0;
		int lastIndex = expression.length();
		while (isBalanced && currenCharIndex < lastIndex) {
			char currentChar = expression.charAt(currenCharIndex);
			int openIndex = openSet.indexOf(currentChar);
			if (openIndex != -1) {
				stack.push(openIndex);
			} else {
				int closeIndex = closeSet.indexOf(currentChar);
				if (closeIndex != -1) {
					try {
						openIndex = stack.top();
						stack.pop();
						if (closeIndex != openIndex) {
							isBalanced = false;
						}
					} catch (StackUnderflowException e) {
						isBalanced = false;
					}
				}

			}
			currenCharIndex++;
		}

		if (!stack.isEmpty()) {
			return 2;
		} else if (!isBalanced) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Instantiate new Balanced class with grouping symbols.
		BalancedExpression bal = new BalancedExpression("([{", ")]}");

		int result; // 0 = balanced, 1 = unbalanced, 2 = premature end

		String expression = null; // expression to be evaluated
		final String STOP = "X"; // indicates end of input

		while (!STOP.equals(expression)) {
			// Get next expression to be processed.
			System.out.print("Expression (" + STOP + " to stop): ");
			expression = sc.nextLine();
			if (!STOP.equals(expression)) {
				// Obtain and output result of balanced testing.
				result = bal.test(expression);
				if (result == 1)
					System.out.println("Unbalanced \n");
				else if (result == 2)
					System.out.println("Premature end of expression \n");
				else

					System.out.println("Balanced \n");
			}
		}
	}
}
