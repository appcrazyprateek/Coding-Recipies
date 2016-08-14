package org.prateek.blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate given amount of first prime numbers
 * Steps.
 * 1. Add 2 as exceptional case
 * 2. check of all odd numbers starting from 3 , if they are prime numbers, increment by 2 as even numbers are not prime
 * 3. if the number is prime, then increase the local count 
 * @author Prateek
 */
public class GeneratePrime {

	public static void main(String[] args) {
		GeneratePrime obj=new GeneratePrime();
		//obj.generatePrime(1000000);
		List<Integer> list=obj.generatePrime(1000000);
		for(Integer i:list)
			System.out.print(i + "\t");
	}
	
	
	/**
	 * Divides the given number starting from 3 to check for factors till n/2,
	 * if factor exists, return false
	 * Checks if Given number is prime or not
	 * @param n: given number
	 * @return: true if number is prime
	 */
	private boolean isPrime(int n){
		if(n%2==0)
			return false;
		else{
			for(int i=3;i<=n/2;i=i+2){
				if(n%i==0)
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Genrerate number of prime numbers as specifeid in argument
	 * @param givenCount: number of primes required
	 * @return. List of prime Numbers
	 */
	public List<Integer> generatePrime(int givenCount) {
		int count=0;
		int i=0;
		List<Integer> primeNums= new ArrayList<Integer>();
		
		//exceptional case
		primeNums.add(2);
		count=1;
		i=3;
		
		while(count < givenCount){
			if(isPrime(i)){
				primeNums.add(i);
				count++;
			}
			i=i+2;
		}
		
		return primeNums;
	}
}


