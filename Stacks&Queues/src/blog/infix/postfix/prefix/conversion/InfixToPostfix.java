package blog.infix.postfix.prefix.conversion;

import java.util.Stack;

/**
 * Infix to Postfix Convertion
 * @author rpratee
 *
 */
public class InfixToPostfix {

	private static final char OPEN_BRACE = '(';
	private static final char CLOSE_BRACE = ')';

	public String infixToPostfix(String expression) throws Exception {
		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int len = expression.length();
		for (int i = 0; i < len; i++) {

			char ch = expression.charAt(i);

			// If Operand, append to output
			if (Character.isLetterOrDigit(ch))
				output.append(ch);

			else if (ch == OPEN_BRACE)
				stack.push(ch);

			else if (ch == CLOSE_BRACE) {
				// pop until u find open brace, we trying to solve for the brace
				while (!stack.isEmpty() && stack.peek() != OPEN_BRACE)
					output.append(stack.pop());

				// If Stack is empty Or Stack Top is not a opening brace, throw
				// exception
				// 2nd part of condition will be executed only when first part
				// is false, so isEmpty check is not required.
				if (stack.isEmpty() || stack.peek() != OPEN_BRACE)
					throw new Exception("Invalid Expression");

				stack.pop(); // pop-out opening brace
			} else {
				while (!stack.isEmpty() && getPriority(ch) <= getPriority(stack.peek())) {
					//Open Brace has -1 priority, if anything equivalent to it comes, 
 					//in that case either there is junk character
					if (stack.peek() == OPEN_BRACE)
						throw new Exception("Invalid Expression");

					output.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		return output.toString();
	}

	private int getPriority(char character) {
		int priority;
		switch (character) {
		case '+':
		case '-':
			priority = 1;
			break;

		case '/':
		case '*':
			priority = 2;
			break;

		case '^':
			priority = 3;
			break;

		//This will also include Open Braces	
		default:
			priority = -1;
			break;
		}
		return priority;
	}

	public static void main(String[] args) throws Exception {
		String expression = "a+b*(c^d-e)^(f+g*h)-i";
		InfixToPostfix obj = new InfixToPostfix();
		String output = obj.infixToPostfix(expression);
		System.out.println("Input :  "+ expression);
		System.out.println("Output:  "+ output);
	}
}
