package com.morganstanley;

import org.prateek.blog.Test;

public class Solution {

	
	
	public static void main(String[] args) {
		//reverse(1200);
		CalculateReverseSum(34,1);
	}

	 static int CalculateReverseSum(int input1, int input2) {
		 return reverse( reverse(input1) + reverse(input2));
	    }
	
	private static int reverse(int n) {
		int reverse =0;
		 while( n != 0 )
	      {
	          reverse = reverse * 10;
	          reverse = reverse + n%10;
	          n = n/10;
	      }
		return reverse;
	}
}
