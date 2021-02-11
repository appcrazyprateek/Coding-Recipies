package blog.dp.knapsack;

public class KnapSack {

	public static void main(String[] args) {
		 int val[] = {60, 100, 120};
		    int wt[] = {10, 20, 30};
		    int  W = 50;
		    knapSack(W,wt,val);
	}
	
static int knapSack(int W, int wt[], int val[])
	{
	   int n = val.length, i , w;
	   int[][] K = new int[n+1][W+1];   //n+1 , W+1 because we are considering 0 weigth and 0th weight
	 
	   //Building tale
	   for (i = 0; i <= n; i++)
	   {
	       for (w = 0; w <= W; w++)
	       {
	           if (i==0 || w==0)
	               K[i][w] = 0;
	               
	           else if (wt[i-1] <= w)   //Considering the weight
	                 K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
	           else     //Not considering the weight
	                 K[i][w] = K[i-1][w];
	       }
	   }
	 
	   return K[n][W];
	}
}
