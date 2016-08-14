package blog.fibonnaci.optimised;
/**
 * Find the Nth Fibbonacci Number using Matrix Exponentiation Method
 * @author PRATEEK
 *
 */
public class FibbonacciNumber {

	private static int[][] F = { { 1, 1 }, { 1, 0 } }; // will change , and will capture rsult here
	private static int[][] I = { { 1, 1 }, { 1, 0 } }; //will remain fixed
	
	public static int fib(int n){
		if(n==0)
			return 0;
		power(F,n-1);
		
		return F[0][0];
	}
	
	/**
	 * Calculates F to the power n
	 * @param F
	 * @param n
	 */
	private static void power(int[][] F, int n) {
		if(n==0 || n==1)
			return;
		
		power(F,n/2);
		multiplyMatrix(F,F);
		
		if(n%2!=0)
			multiplyMatrix(F, I);
	}
	
	/**
	 * Multiples Matrixes of size 2X2
	 */
	public static int[][] multiplyMatrix(int[][] A, int[][] B)
	{
		  int x =  A[0][0]*B[0][0] + A[0][1]*B[1][0];
		  int y =  A[0][0]*B[0][1] + A[0][1]*B[1][1];
		  int z =  A[1][0]*B[0][0] + A[1][1]*B[1][0];
		  int w =  A[1][0]*B[0][1] + A[1][1]*B[1][1];
		 
		  A[0][0] = x;
		  A[0][1] = y;
		  A[1][0] = z;
		  A[1][1] = w;
		  
		  return A;
	}
	
	public static void main(String[] args) {
		//1,1,2,3,5,8,13,21,34,55,89...
		int n = 8;
		System.out.println(n + "--->" + fib(n));
	}
	
	/**
	 * recursiver approach , exponential Complexity
	 * @param n
	 * @return
	 */
	public static int fib1(int n)
	{
		if(n<=1)
			return n;
		return fib1(n-1) + fib(n-2);
	}
	
	/**
	 * DP approach , O(n) complexity
	 */
	public static int fib2(int n)
	{
		if(n==0)
			return 0;
		int old1=0 , old2=1 , curr,i=2;
		for(;i<=n;i++)
		{
			curr = old1 + old2;
			old1= old2;
			old2 = curr;
		}
		return old2;
	}
}
