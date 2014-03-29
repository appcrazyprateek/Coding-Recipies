package blog.stack.misc;

import java.util.Stack;
interface StackImpl{
	void push(int data);
	int pop();
    int getMin();
    int peek();
    boolean isEmpty();
}
/**
 * Implement Stack with Minimum Element Lookup in Constant Time
 * @author Prateek Rathore
 */
public class StackWithMinItem implements StackImpl{

	private Stack<Integer> minStack; // stack holding min Element
	private Stack<Integer> original; // orginal stack holding data

	public StackWithMinItem() {
		this.original = new Stack<Integer>();
		this.minStack = new Stack<Integer>();
	}
	/**
	 * Push Subroutine
	 */
	@Override
	public void push(int data) {
		if(original.isEmpty())
			minStack.push(data);

		else{
			if(data < minStack.peek())
				minStack.push(data);
		}
		original.push(data);
	}

	/**
	 *Pops element from the custom stack 
	 */
	@Override
	public int pop() {
		if(original.peek() == minStack.peek())
			minStack.pop();

		return original.pop();
	}
	
	/**
	 * Peek Minimum Element
	 */
	@Override
	public int getMin(){
		return minStack.peek();
	}

	/**
	 * Peek for the element
	 */
	@Override
	public int peek() {
		return original.peek();
	}

	@Override
	public boolean isEmpty() {
		return original.isEmpty();
	}

	public static void main(String[] args) {
		StackWithMinItem stack = new StackWithMinItem();
		
		//7 , 6 , 8 , 5 , 2 , 3, 1, 9, 4
		stack.push(7);
		stack.push(6);
		stack.push(8);
		stack.push(5);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(9);
		stack.push(4);
		System.out.println("Minimum Eleement is : "+ stack.getMin());
		System.out.println("Poped : " + stack.pop());
		System.out.println("Poped : " + stack.pop());
		System.out.println("Poped : " + stack.pop());
		System.out.println("Minimum Eleement is : "+ stack.getMin());
	}
}
