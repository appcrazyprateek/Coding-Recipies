package blog.happyprimenumber ;

import java.util.HashSet;
import java.util.Set;
/**
 * Print happy prime numbers
 * @author PRATEEK
 *
 */
public class HappyPrimeNumber {
	
	/**
	 * Prints n happy prime numbers
	 * @param n : number of primes to be printed
	 */
	public static void happyPrimes(int n)
	{
		int count =0,i=7;
		for(;i<1000 && count <n ; i +=2 )
		{
			if(isPrime(i) && isHappy(i, new HashSet<Integer>()))
			{
				count++;
				System.out.println(i);
			}
			
		}
			
	}
	
	/**
	 * To check if the number is Happy
	 * Happy Number (WIKIPEDIA): A happy number is a number defined by the 
	 * following process: Starting with any positive integer, replace 
	 * the number by the  sum of the squares of its digits, and repeat the process until 
	 * the number equals 1 (where it will stay), or it loops endlessly in a 
	 * cycle which does not include 1. Those numbers for which this process ends in 1
	 *  are happy numbers, while those that do not end in 1 are unhappy numbers (or sad numbers)
	 * @return: true if number is happy
	 */
	private static boolean isHappy(int num, Set<Integer> set){
		if(!set.add(num))
			return false;
		if(num==1)
			return true;
		
		int digit=0,sum=0;
		while(num > 0)
		{
		  	digit = num % 10;
		  	num /=10;
		  	sum  += digit * digit ;
		}
		return isHappy(sum, set);
	}
	
	private static boolean isPrime(int num)
	{
		if(num%2==0 || num<2 )
		   return false;
		if(num==2)
			return true;
			
		for(int p=3;p<=num/2; p+=2)
			if(num%p==0)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		happyPrimes(5);
	}
	
}
