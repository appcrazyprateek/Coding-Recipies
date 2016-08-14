package blog.sort.stack;

import java.util.Stack;

/**
 * Sort the stack using two arrays
 * @author PRATEEK
 */

public class SortStack {

	/*
	 * Sort Sub-routine using 
	 */
	public Stack<Integer> sort(Stack<Integer> original){
	
		Stack<Integer> duplicate = new Stack<Integer>();
		
		while(!original.isEmpty())
		{
			int temp = original.pop();
			while(!duplicate.isEmpty() && duplicate.peek()< temp)
				duplicate.push(original.pop());

			duplicate.push(temp);
		}
		
		 
		
		return duplicate;
	}
	
	
	public static void main(String[] args) {
		
	}
}
