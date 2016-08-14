package algo;

import java.util.Scanner;

public class Algorithm {
	static int N;
	static int NOT_DECIDED = 0;
	static int IS_PRIME = 1;
	static int IS_NOT_PRIME = 2;

	static int MAX_N = 100000001;
	
	//static int[] PRIMES = new int[MAX_N];
	
	public static boolean isPrime(int n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}
	
	public static void getPrime(int depth, int currentNum)
	{
		//System.out.println("Depth = " + depth);
		for(int i = 0; i <= 9; i++)
		{
			int val = currentNum*10 + i;
			boolean prime = false;
			if(isPrime(val))
				if(depth >= N)
					System.out.println(val);
				else
					getPrime(depth + 1, val);
		}
	}

	
	public static void main(String args[]) throws Exception	{
		
		getPrime(3,0 );
		/*Scanner sc = new Scanner(System.in);
	//	sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			N = sc.nextInt();
			
			*//**********************************
			*  Implement your algorithm here. *
			***********************************//*

			// Print the answer to standard output(screen).
			getPrime(1,0 );
			System.out.println();
		}*/
	}
}