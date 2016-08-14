package blog.kadanesubarray;

import java.util.HashMap;
import java.util.Map;

public class KadaneSubarray {

	public static void main(String[] args) {
		KadaneSubarray obj=new KadaneSubarray();
	//	int arr[]={3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
		 int arr[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		int maxSum=obj.kadane(arr);
		System.out.println("Max Sum:  "+maxSum);
	}
	
	public int kadane(int arr[])
	{
		
		Map m = new HashMap();
		int currentSum=arr[0];
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++)
		{
			currentSum=currentSum + arr[i];
			
			if(currentSum<0)
				currentSum=0;
			else if(maxSum<currentSum)
				maxSum=currentSum;
		}
		return maxSum;
	}
	
}
