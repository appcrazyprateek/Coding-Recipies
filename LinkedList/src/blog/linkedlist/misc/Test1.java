package blog.linkedlist.misc;

import java.util.Arrays;

public class Test1 {
	
	static int[] arr = new int[100];
	int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
		return 1;
		
		if(arr[n] != -1)
			return arr[n];
		
		arr[n] = fib(n - 1) + fib(n - 2);
		return arr[n];
	}
	

	
	public static void main(String[] args) {
		Arrays.fill(arr, -1);
		
		Test1 obj = new Test1();
		long t1 = System.currentTimeMillis();
		obj.fib(40);
		long t2 = System.currentTimeMillis();
		System.out.println("Time Taken(ms) : ---> " + (t2-t1));
		
		/*
		 * t1 = System.currentTimeMillis(); obj.fib(1000); t2 =
		 * System.currentTimeMillis(); System.out.println("Time Taken(ms) : ---> " +
		 * (t2-t1));
		 */
	}
	

}
