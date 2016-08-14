package blog.sorting.selection;

import java.util.Arrays;

public class Selection {
  
	public static void main(String[] args) {
		
		int[] arr= {2, 3, 4,8,3,6,9};
		arr= selection(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static int[] selection(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			int minIndex = min(arr,i+1);
			if(arr[i] > arr[minIndex])
			swap(arr, i , minIndex);
		}
		return arr;
	}
	
	static int min(int []arr , int index){
		int min = Integer.MAX_VALUE;
		int j = index;
		for(int i=index;i<arr.length;i++)
		{
			if(min > arr[i])
			{
				min = arr[i];
				j=i;
			}
		}
		return j;
	}
	
	
	public static void swap(int [] arr, int a, int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
