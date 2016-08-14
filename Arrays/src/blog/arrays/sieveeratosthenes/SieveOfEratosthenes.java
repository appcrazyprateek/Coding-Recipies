/**
 * 
 */
package blog.arrays.sieveeratosthenes;

import java.util.Arrays;

/**
 * @author prathore2
 *
 */
public class SieveOfEratosthenes {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(generatePrimes(50)));
	}
	
	
	
	public static int[] generatePrimes( int n){
		
		int[] primes = new int[n+1];
		Arrays.fill(primes, 1);
		
		primes[0] = 0;
		primes[1] = 0;
		
		for(int i=2;i<=Math.sqrt(n);i++){
			 if(primes[i] == 1){
				 for(int j=2 ; i*j < n ; j++)
					 primes[i*j] = 0;
			 }	 
		}	 
		
		return primes;
				 
	}
}
