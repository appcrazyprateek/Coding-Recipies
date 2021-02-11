package blog.infix.postfix.prefix.conversion;

import java.util.Stack;

public class PostfixToInfix {

	public String postfixToInfix(String expression) {
		Stack<String> stack = new Stack<>();
		int len = expression.length();
		for (int i = 0; i < len; i++) {
			char c = expression.charAt(i);

			if (c == '*' || c == '/' || c == '^' || c == '+' || c == '-') {
				String item1 = stack.pop();
				String item2 = stack.pop();
				stack.push("(" + item2 + c + item1 + ")");
			} else 
				stack.push(c + "");
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String exp = "ABC/-AK/L-*";
		System.out.println("Postfix Expression: " + exp);
		System.out.println("Infix Expression: " + new PostfixToInfix().postfixToInfix(exp));
	}
}
