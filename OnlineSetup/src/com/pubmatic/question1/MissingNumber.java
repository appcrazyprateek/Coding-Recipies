package com.pubmatic.question1;

/**
 * Find the number which has been deleted from the array 2,
 * The approach invloves simply subtracting the sum of the arrays
 * @author PRATEEK
 */
public class MissingNumber {

	public static void main(String[] args) {
		
		int[] arr1={4,1,0,2,9,6,8,7,5,3};
		int[] arr2={6,4,7,2,1,0,8,3,9};
		
		System.out.println(missingNumber(arr1,arr2));
	}
	
	public static int missingNumber(int[] arr1,int[] arr2){
		int sum1=0,sum2=0;
		
		for(int i:arr1)
			sum1+=i;
		
		for(int i:arr2)
			sum2+=i;
		
		return sum1-sum2;
	}
}
