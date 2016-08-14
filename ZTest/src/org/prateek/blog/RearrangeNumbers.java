package org.prateek.blog;
import java.util.Arrays;

/**
 * @author Isha
 */
public class RearrangeNumbers {

	/**
	 * 
	 * @param arr: Input array
	 * @return rearranged array
	 */
	public int[] solve(int[] arr){
		int[] out = new int[arr.length];
		
		int low=0,high=arr.length-1;
		
		for(int i=0;i<arr.length;i++){
			if(arr[i]>=0)
				out[low++]=arr[i];
			else
				out[high--]=arr[i];
		}

		//System.out.println(Arrays.toString(out));
		
		high = arr.length -1;
		while(low < high){
			swap(out,low++,high--);
		}
		
		
		System.out.println("output: " + Arrays.toString(out));
		return out;
	}
	
	public void swap(int[] arr , int i , int j){
		int temp=arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		RearrangeNumbers obj= new RearrangeNumbers();
		int[] arr= {5, -4 , 3 , -2 , 6 , -11, 12 , -8 , 9 };
		System.out.println("input:  " + Arrays.toString(arr));
		obj.solve(arr);
	}
}
