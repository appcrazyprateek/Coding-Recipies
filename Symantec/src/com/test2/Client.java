package com.test2;

import java.util.Arrays;

public class Client {;

	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9} ;
		int size  = 3;
		solve(arr, size);
		System.out.println(Arrays.toString(arr));
	}

	private static void solve(int[] arr, int size ) {
		int len = arr.length;
		int i=0, j = 0, k=0;
		
		while(k<len)
		{
			i=k;
			k = i + size;
			j= i + size -1 ;
			
			if(i<len && j<len)
			{
				
				startSwapping(arr,i,j);
			}
			else
			{
				j=len-1;
				k=len;
				startSwapping(arr,i,j);
				
			}
			
		}
	}

	private static void startSwapping(int[] arr, int i, int j) {
		for(;i<=j;i++,j++)
		{
			swap(arr, i , j);
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		System.out.println(i + "  " + j);
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
}
