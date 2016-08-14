package org.prateek.blog;

/**
 * Prints intersection of Arrays
 * @author Prateek
 */
public class Intersection {

	public static final int MAX=10;  // higherst value of the two given arrays , pick values from 1  to 10 only
	
	//choose prime numbers only 
	private static final int FACT1= 3;
	private static final int FACT2= 7;
	private int[] temp= new int[MAX];

	
/**
 * Prints out intersetion of arrays , even with non-unique elements in a given arrays
 * Failure case: program will fail in few scenarios , but choise of primes numbers as FACT1 and FACT2 will reduce the probabiluty of failure
 * @return
 */
	public int[] getIntersection(int[] arr1, int[] arr2){

		for(int i=0;i<arr1.length;i++)
			temp[arr1[i]] = temp[arr1[i]] + FACT1 ;

		for(int i=0;i<arr2.length;i++)
			temp[arr2[i]] = temp[arr2[i]] + FACT2 ;


		for(int i=0;i<temp.length;i++){
			if(! (temp[i]==0))
				if( ! (temp[i]%FACT1==0 || temp[i]%FACT2==0))
					System.out.println(temp[i]);

		}
		return temp;
	}

	public static void main(String[] args) {
			
	}
}
