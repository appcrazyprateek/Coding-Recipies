package blog.stack.stockproblem;

import java.util.Arrays;
import java.util.Stack;
/**
 * Write algorithm , TODO : comments to be updated
 * @author PRATEEK
 *
 */
public class StockProblem {

	public static void main(String[] args) {
		int[] stocks  =  {100, 80 , 60, 70 , 60 , 75, 85};
		StockProblem obj = new StockProblem();
		obj.solve(stocks);
	}
	
	
	
	public void solve(int[] stocks)
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int[] sol = new int[stocks.length];
		sol[0]=1;
		
		for(int i=1;i<stocks.length;i++)
		{
			while(!stack.isEmpty() && stocks[stack.peek()]<stocks[i])
				stack.pop();
			
			sol[i] = stack.isEmpty() ? i+1: i - stack.peek();
			stack.push(i);
		}
		System.out.println(Arrays.toString(sol));
	}
}
