package com.math.pallindromecheck;
/**
 * Recursive apporach to check if a number is pallindrome without extra space
 * @author prathore2
 */
public class PallindromeCheck {

	private static int dummy = 0;
	public static boolean isPallindrome(int num) {
		dummy = num;
		return isPallindrome1(num);
	}

	private static boolean isPallindrome1(int num) {
		if (num == 0)
			return true;
		if (isPallindrome1(num / 10) && (num % 10 == dummy % 10)) {
			dummy /= 10;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPallindrome(12321));
	}
	
	private static boolean isPallindrome2(int num) {
		int div = 1;
		
		if(num < 0)
			num = -num;
		
		for(;num/div>=10;div *=10);  
		//div which will help in dividing below, [Note : dont Miss ';']
		  
		while (num != 0) {
		    int leftDigit = num / div;  
		    int rightDigit = num % 10;
		    if (leftDigit != rightDigit) 
		    	return false;
		    num %= div ;	 //removes left most digit
		    num /= 10 ;		 //removes right most digit
		    div /= 100;
		  }
		return true;
	}
	
}
