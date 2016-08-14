/**
 * 
 */
package blog.arrays.countsubsequencewithsum;

import java.util.Arrays;
import java.util.List;


//TODO Complete the code, not giving coreeect results 
/**
 * Count Subsequence with given sum 'S' lying in the range [B,C]
 * @author prathore2
 *
 */
public class CountSubsequence {

	public static void main(String[] args) {
		Integer[] arr = {80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90 };
		int B = 99;
		int C = 269;
		numRange(Arrays.asList(arr), B, C);
	}

	public static int numRange(List<Integer> A, int B, int C) {
		Integer[] arr = A.toArray(new Integer[A.size()]);
		return countSubsequence(arr, B, C);
	}
	
	private static int countSubsequence(Integer[] arr, int low, int high) {
		int fast = 0;
		int slow = 0;
		int len = arr.length;
		int count = 0;
		
		int sum = 0;
		while(fast < len)
		{
			int currSum  = sum+arr[fast] ;
			if( currSum >= low && currSum <= high)
			{
				sum +=arr[fast];
				fast++;
				count++;
			}
			else if(currSum < low)
			{
				sum += arr[fast];
				fast++;
			}
			else if( currSum >  high)
			{
				if(slow!=0)
				sum -=arr[slow];
				slow++;
				if(slow >= fast)
					fast++;
			}
		}
		while(slow<len)
		{
			sum -=arr[slow];
			if(sum >= low && sum <= high)
			{
				count++;
			}
			slow++;
		}
		
		//System.out.println(count);
		return count;
	}
	
	
}
