package blog.misc;

import java.util.Arrays;

/**
 * Rotate an array by amount K
 * @author PRATEEK
 */
public class RotateArray {
	private static int arr[]={1,2,3,4,5,6,7,8,9,10};

	public static void main(String[] args) {
		int k=8;
		//rotate1(Arrays.copyOf(arr, arr.length),k);
		rotate2(Arrays.copyOf(arr, arr.length),k);
		//rotateArray(n);
	}
	
	/**
	 * Rotate array by k
	 */
	public static void rotate2(int[] arr, int k) {
		if(k<=0 || arr==null || arr.length==0)
			return ;
		int[] old = Arrays.copyOf(arr, arr.length);
		k--;
		int i=0,j=k,len=arr.length;
		for (; i <=k/2 ; i++,j--)
			swap(arr, i, j);
		
		int temp=  i + (len-i)/2;
		for (i=k+1,j= arr.length-1; i <= temp ; i++,j--)
			swap(arr, i, j);
		
		
		for (i=0,j= len-1; i <len/2 ; i++,j--)
			swap(arr, i, j);
		
		System.out.println(Arrays.toString(old) + "-->"+ Arrays.toString(arr));
	}
	
	
	public static void rotate1(int[] arr, int k) {
		int[] old = Arrays.copyOf(arr, arr.length);
		
		int i = 0;
		for (; i + k < arr.length; i++)
			swap(arr, i, i + k);
		
		if(k!=0 && arr.length % k !=0)
		{
			k--;
			for (; i < arr.length - 1; i++, k--)
				swap(arr, i, i + k);
		}
		
		System.out.println(Arrays.toString(old) + "-->"+ Arrays.toString(arr));
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	

	public static void rotateArray(int n)
	{
		for(int i=0;i<n;i++)
		{
			rotateByOne();
		}
	}

	public static void rotateByOne()
	{
		int temp=arr[0];
		for(int i=0;i<=arr.length-2;i++)
		{
			arr[i]=arr[i+1];
		}
		arr[arr.length-1]=temp;
	}
}
