package com.blog.validate.stacksequence;

import java.util.Stack;

public class ValidateStackSequence {

	public boolean validateStackSequences(int[] pushed, int[] popped) {

		int len = pushed.length;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int j = 0;
		while (i < len) {
			if (pushed[i] == popped[j]) {
				j++; //Match is found so this element would be pushed and then poped

				// check for other elements in the stack as well.
				while (!stack.isEmpty() && stack.peek() == popped[j]) {
					stack.pop();
					j++;
				}
			}
			else  //If No Match  found for i, and j index elements , push element
				stack.add(pushed[i]);
			
			i++;
		}

		while (!stack.isEmpty()) {
			if (stack.pop() == popped[j])
				j++;
			else
				return false;
		}

		return stack.isEmpty();

	}

	public static void main(String[] args) {
		ValidateStackSequence obj = new ValidateStackSequence();
		int[] pushed = {1,2,3,4,5};
		int[] poped = {4,5,3,2,1};
		boolean isValid = obj.validateStackSequences(pushed, poped);
		System.out.println("Sequence is " + (isValid ? "Valid " : "Not Valid"));
	}
}
