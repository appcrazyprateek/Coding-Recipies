package blog.dp.knapsack;

import java.util.Stack;

public class RecursiveKnapsack {

	//Weight and Value Price given of the weights
	public static void main(String args[]) {
		int p[] = new int[] { 60, 100, 120 };
		int w[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = p.length;
		System.out.println(knapSack(W, n, w, p));
		
		Stack<Integer> a = null;
	}

   
	private static int knapSack(int W, int n, int w[], int p[] ) {
		
		if (n == 0 || W == 0)
			return 0;

		if (w[n - 1] > W)
			return knapSack(W, n - 1, w, p);

		else
			return Math.max(p[n - 1] + knapSack(W - w[n - 1], n - 1,  w, p),
					knapSack(W, n - 1, w, p));
	}
}
