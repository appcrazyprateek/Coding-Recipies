package blog.stack.misc;

import java.util.Stack;
/**
 * Recursive Inplace Stack Sorting 
 * @author Prateek
 */
public class SortStack {

	//input stack
	private Stack<Integer> stack; 
	
	public SortStack(Stack<Integer> stack) {
	this.stack=stack;
	}
	
	/**
	 * Sorting Subroutine 
	 */
	public void sort(){
		if(stack.isEmpty())
			return;
		
		int item=stack.pop();
		sort();
		compareAndPush(item);
	}
	
	/**
	 * Pushing each element of stack by recursion
	 * @param item: each item of stack which is compared and pushed to stack
	 */
	public void compareAndPush(int item){
		if(stack.isEmpty() || item <= stack.peek())
			stack.push(item);
		else {
			int val=stack.pop();
			compareAndPush(item);
			stack.push(val);
		}	
	}
	
	
	public static void main(String[] args) {
		
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(5);
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(2);
		SortStack obj= new SortStack(stack);
		obj.sort();
		
		System.out.println(stack);
	}
}
