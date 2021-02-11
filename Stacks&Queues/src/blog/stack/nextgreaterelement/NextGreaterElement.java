package blog.stack.nextgreaterelement;

import java.util.Stack;

/**
 * Print the next greater element to every element in an array , if no greater
 * element exists for a number print -1
 * 
 * @author PRATEEK
 */
public class NextGreaterElement {

	/**
	 * Next Greater element on the right
	 * 
	 * @param arr
	 *            input array
	 */
	public static void nextElement(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > stack.peek()) {
				System.out.println(stack.pop() + " --> " + arr[i]);
			}
			stack.push(arr[i]);
		}

		while (!stack.isEmpty())
			System.out.println(stack.pop() + " --> " + -1);

	}

	public static void main(String[] args) {
		int[] arr = { 11, 0, 4, 7, 6, 3, 2, 5, 1, 100, 9 };
		nextElement(arr);
	}
}
