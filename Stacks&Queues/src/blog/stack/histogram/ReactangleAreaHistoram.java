package blog.stack.histogram;

import java.util.Stack;
//http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class ReactangleAreaHistoram {

	public static int findMaxRectArea(int[] his)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		int max_area = 0;
		int top=-1;
		int area_top;
		
		int n= his.length;
		
		int i=0;
		while(i<n)
		{
			if(stack.isEmpty() || his[i] >= his[stack.peek()] )
				stack.push(i++);
			else
			{
				top=stack.pop();
				
				//Very imp line
				area_top = his[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				
				 if (max_area < area_top)
		                max_area = area_top;
			}
		}
		 return max_area;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {6, 2, 5, 4, 5, 1, 6};
		int val = findMaxRectArea(arr);
		System.out.println(val);
	}
	
}
