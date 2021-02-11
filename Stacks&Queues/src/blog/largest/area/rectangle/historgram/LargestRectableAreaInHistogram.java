package blog.largest.area.rectangle.historgram;

import java.util.Stack;

public class LargestRectableAreaInHistogram {

	public static void main(String[] args) {
		int[] heights = { 2,1,5,6,2,3 };
		int area = calculateArea(heights);
		System.out.println("Max Rectangular area in histogrm is " + area);
	}
	
	public static int calculateArea(int[] heights) {
		int len = heights.length;
		int maxArea = -1, area = 0, top = -1;
		Stack<Integer> stack = new Stack<>();
		
		int i= 0;
		while( i< len) {
			
			/**
			 * insert element to stack if incoming element is larger than top of the stack. 
			 */
			if(stack.isEmpty() || heights[i] >= heights[stack.peek()])
				stack.push(i++);
			
			/**
			 * Pop elements from stack until bar on top if the stack is greater than incomming element
			 */
			else {
				top = stack.pop();
				int lowBound = !stack.isEmpty() ? stack.peek() : -1; 
				area = heights[top] * (i -1 - lowBound);
				
				System.out.println("area -- >" + area);
				maxArea = Math.max(area, maxArea);
			}
		}
		
		// Empty all the stack elements and calcualte area for each one of them.
		while(!stack.isEmpty()) {
			//Another way of writing the same condition as used above
			top = stack.pop();
			area = heights[top] * (stack.isEmpty() ? i : (i - 1 - stack.peek()));
			
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}
}
