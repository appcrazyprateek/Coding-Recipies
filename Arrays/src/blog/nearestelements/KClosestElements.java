package blog.nearestelements;

import java.util.Arrays;

/**
 * Find K closest elements to a given number in a sorted array
 * @author PRATEEK
 */
public class KClosestElements {

	
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9,10,11};
		int index=binarySearch(arr, 7, 0, arr.length);
		int k=4;
		if(index!=-1)
		{
			int[] result=KClosestElements(arr,index,k);
		}
	}

	private static int binarySearch(int[]arr,int num,int low,int high) {
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(arr[mid]==num)			return mid;
			else if(arr[mid] < num)		low=mid+1;
			else if (arr[mid] > num)	high=mid-1;
		}
		return -1;
	}
	
	public static int[] KClosestElements(int[] arr, int index, int k){
		int left = index -1;
		int right = index +1;
		int[] result = new int[k];

		while(right - left -2 < k )
		{
			if(arr[right] - arr[index] > arr[index]- arr[left])
			{
				if(left>0)
					result[right - left - 2] = arr[left--];
				else 
					result[right - left - 2]=arr[right++];
			}
			else
			{
				if(right < arr.length)
					result[right - left - 2]=arr[right++];
				else
					result[right - left - 2] = arr[left--];
			}
			
			//result[right - left] = arr[right] - arr[index] > arr[index]- arr[left] ?  if(left>0){arr[left--]} : arr[right++] ;
		}
		System.out.println(Arrays.toString(result));
		
		return result;
	}
}
