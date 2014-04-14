package blog.search.binarysearch;

/**
 * Given array of 0s and 1s , find where 0s start
 * @author PRATEEK
 *http://ideone.com/hqCpxJ
 */
public class FindPosition {

	public int findPosition(int[] arr, int low, int high)
	{
		if(low < high)
		{
			int mid = (low+high)/2;
			
			if(arr[mid]==0 && arr[mid+1]==1)
				return mid;
			
			if(arr[mid]==0 && arr[mid+1]==0)
				findPosition(arr, mid, high);
			
			if(arr[mid]==1 && arr[mid+1]==1)
				findPosition(arr, mid, high);
			
		}
		return high;
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
