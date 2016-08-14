package blog.dp.knapsack;
/*package knapsack;

public class deposit {
	 int K[][];
	public static void main(String[] args) {
		KnapSack k=new KnapSack();
		k.helper();
	}
	
	//		int[] values={15,10,9,5};
//		int[] weights={1,5,3,4,};
//		int knapsackCapacity=8;
		//  ans: 29	

//				int[] values={1,6,18,22,28};
//				int[] weights={1,2,5,6,7};
//				int knapsackCapacity=5;
		//  ans: 18	

	
	private void helper()
	{
		//int val[] = {60, 100, 120};
	    //int wt[] = {10, 20, 30};
		int val[] = {3,6,7,9,11,18};
		int wt[] = {1,2,3,5,6,8};
		int n=val.length;
	    int  W = 1;
	    
	   int v= knapSack(W, wt, val, n);
	    
	   System.out.println(v);
	   
	    //print(K,n,W);
	}
	
	
	private int knapSack(int W, int wt[], int val[], int n)
	{
	   int i, w;
	  // int K[n+1][W+1]=new int[n+1][W+1];
	   int K[][]=new int[n+1][W+1];
	   // Build table K[][] in bottom up manner
	   for (i = 0; i <= n; i++)
	   {
	       for (w = 0; w <= W; w++)
	       {
	           if (i==0 || w==0)
	               K[i][w] = 0;
	           else if (wt[i-1] <= w)
	                 K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
	           else
	                 K[i][w] = K[i-1][w];
	       }
	   }
	 
	   for ( i = 0; i <= n; i++)
	   {
	       for ( w = 0; w <= W; w++)
	       {
	    	   System.out.print(K[i][w]);
	       }
	       System.out.println();
	   }
	   
	   return K[n][W];
	}
	
	public void print(int K[][], int n, int W)
	{
		 for (int i = 0; i <= n; i++)
		   {
		       for (int w = 0; w <= W; w++)
		       {
		    	   System.out.println(K[i][w]);
		       }
		   }
	}
	
	private int max(int a , int b)
	{
		return a > b ? a : b ;
	}
}
*/