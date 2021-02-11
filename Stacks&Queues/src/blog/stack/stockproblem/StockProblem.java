package blog.stack.stockproblem;

import java.util.*;
public class StockProblem {

	public static void main(String[] args) {
		int[] stocks  = { 10, 4, 5, 90, 120, 80 };
		StockProblem obj = new StockProblem();
		obj.bruteForce(stocks);  //Brute Force 
		obj.stackBased(stocks); // Stack based solution
		String s;
	}
	
	//Brute force appraoch
	int[] bruteForce(int[] stocks) {
		int len = stocks.length, i , j ;
		int[] span = new int[len];
		span[0] = 1;
		
		for (i = 1; i < len; i++) { 
			for (j = i - 1, span[i] = 1; j >= 0 && stocks[i] >= stocks[j]; j--, span[i]++);
		}
		System.out.println(Arrays.toString(span));
		return span;
	}
	
	//stack based approach
	int[] stackBased(int[] stocks)
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int[] sol = new int[stocks.length];
		sol[0]=1;
		
		for(int i=1;i<stocks.length;i++)
		{
			//if incoming element is greater, Pop until u find greater element index in the stack 
			for(;!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]; stack.pop());
			
			sol[i] = stack.isEmpty() ? i + 1: i - stack.peek();
			stack.push(i);
		}
		System.out.println(Arrays.toString(sol));
		return sol;
	}
}
