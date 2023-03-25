package stack_examples;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import data_strucuture_and_algorithms.stack.ArrayBoundStack;
import data_strucuture_and_algorithms.stack.PostFixEvalutionException;
import data_strucuture_and_algorithms.stack.StackInterface;

/**
 *
 * Postfix expression (X to stop): 5 7 + 6 2 - * Result = 48 Postfix expression
 * (X to stop): 4 2 3 5 1 - + * + * Error in expression Not enough
 * operands-stack underflow Postfix expression (X to stop): X
 * 
 * @author sarya
 *
 */
public class PostFixEvalutor {
	static final List<String> VALID_OPS = Arrays.asList("+", "-", "*", "/");

	public static int evalute(String expression) {
		Scanner sc = new Scanner(expression);
		StackInterface<Integer> stack = new ArrayBoundStack<Integer>(50);
		String operator;
		int operand1, operand2, result = 0;
		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				if (stack.isFull()) {
					throw new PostFixEvalutionException("expression length is more than 50");
				}

				stack.push(sc.nextInt());
			} else {
				operator = sc.next();
				if (!VALID_OPS.contains(operator)) {
					throw new PostFixEvalutionException("Invalid Operator" + operator);
				}

				if (stack.isEmpty()) {
					throw new PostFixEvalutionException("Not Enough operands");
				}
				operand2 = stack.top();
				stack.pop();

				if (stack.isEmpty()) {
					throw new PostFixEvalutionException("Not Enough operands");
				}
				operand1 = stack.top();
				stack.pop();

				switch (operator) {
				case "+":
					result = operand1 + operand2;
					break;
				case "-":
					result = operand1 - operand2;
					break;
				case "*":
					result = operand1 * operand2;
					break;
				case "/":
					result = operand1 / operand2;
					break;
				default:
					break;
				}
				stack.push(result);
			}
		}

		// Obtain final result from stack.
		if (stack.isEmpty())
			throw new PostFixEvalutionException("Not enough operands-stack underflow");
		result = stack.top();
		stack.pop();

		// Stack should now be empty.
		if (!stack.isEmpty())
			throw new PostFixEvalutionException("Too many operands-operands left over");

		// Return the final.
		return result;
	}

	public static void main(String[] args) {
		System.out.println("validate the postfix expression: " + evalute("5 8 + 1 4 + + "));
	}
}
