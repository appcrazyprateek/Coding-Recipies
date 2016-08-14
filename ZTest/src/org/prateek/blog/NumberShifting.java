package org.prateek.blog;

import java.util.Arrays;

/**
 * rearrange the number by shifting LSBs and MSBs
 * @author Prateek
 *
 */
public class NumberShifting {

	public static final int LEFT_SHIFT =101;
	public static final int RIGHT_SHIFT =102;
	
	/**
	 * Shift the given array
	 * @param arr: input array
	 * @param shiftCode: depending on code shift the array left or right
	 * @param numShift: defines the step of shifting
	 * @return 
	 */
	public static int[] shift(int[] arr, int shiftCode ) { // , int shiftSize){
		
		if(shiftCode == LEFT_SHIFT)
		{
			int temp=arr[0];
			for(int i=0;i<arr.length-1;i++)
			    arr[i] = arr[i+1] ;
			arr[arr.length-1]=temp;
		}
		
		else if(shiftCode == RIGHT_SHIFT)
		{
			int temp=arr[arr.length-1];
			for(int i=arr.length-2;i>=0;i--)
			    arr[i+1] = arr[i] ;
			arr[0]=temp;
		}
		
		return arr;
	}

	public static void fillArrays(int[] arr){
		int[] MSBArr = new int[arr.length];
		int[] LSBArr = new int[arr.length];
		
		for(int i=0;i<arr.length ;i++){
			LSBArr[i] = arr[i]%10 ;      //get units place
			MSBArr[i]= (arr[i]/10)%10;   //get tens place
		}
		
		
		//Shift arrays
		LSBArr = shift(LSBArr, LEFT_SHIFT);
		MSBArr = shift(MSBArr, RIGHT_SHIFT);
		
		
		//Print shifted arrays
		//System.out.println(Arrays.toString(LSBArr));
		//System.out.println(Arrays.toString(MSBArr));
		
		
		int[] out=  new int[arr.length];
		for(int i=0;i<arr.length;i++)
			out[i] = MSBArr[i]*10 + LSBArr[i];
		
		System.out.println("input:  "+ Arrays.toString(arr));
		System.out.println("output: "+ Arrays.toString(out));
	}
	
	public static void main(String[] args) {
			int[] arr= {78 , 42 , 39 , 81 , 65 } ;
			//int[] arr= {62 , 79 , 41 , 35 , 88 } ;
			
			fillArrays(arr);
	}
}
