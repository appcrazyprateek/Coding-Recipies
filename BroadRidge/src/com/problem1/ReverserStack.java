package com.problem1;

import java.util.Stack;

public class ReverserStack {

	
	void reverse(Stack<Integer> s) {
		if(s.isEmpty())
			return;
		
		int popItem = s.pop();
		reverse(s);
		insertAtBottom(s, popItem);
	}
	
	private void insertAtBottom(Stack<Integer> s, int item) {
		if(s.isEmpty())
		{
			s.push(item);
			return;
		}
			
		int x = s.pop();
		insertAtBottom(s, item);
		s.push(x);
	}




	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		String s ;
		ReverserStack rev = new ReverserStack();
		rev.reverse(stack);
		
	}
}
