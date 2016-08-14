package blog.stack.reversestack;

import java.util.Stack;
/**
 *  Inplace reversal of Stack
 * @author Prateek
 */
public class ReverseStackRecursion {

	/**
	 * Subroutine to Reverse the element of stack	
	 * @param stack : input stack
	 */
	public void reverseStack(Stack<Integer> stack){
		if(stack.isEmpty())
			return ;

		int val= stack.pop();
		reverseStack(stack);

		pushToBottom(stack,val);
		return ;
	}

	/**
	 * Pushes the incoming element or item to the bottom of the stack	
	 */
	private void pushToBottom(Stack<Integer> stack,int item){
		if(stack.isEmpty()){
			stack.push(item);
			return ;
		}

		int val= stack.pop();
		pushToBottom(stack,item);
		stack.push(val);
	}

	public static void main(String[] args) {
		ReverseStackRecursion obj=new ReverseStackRecursion();
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println(stack);
		obj.reverseStack(stack);

		System.out.println(stack);
	}
}
