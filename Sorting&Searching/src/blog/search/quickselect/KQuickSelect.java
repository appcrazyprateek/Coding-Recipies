package blog.search.quickselect;

public class KQuickSelect {

	public int findKSmallest(int[] arr, int k)
	{
		int len = arr.length;
		
		int low=0, high=arr.length-1;
		
		
		while(low < high)
		{
			int i=low, j= high;
			
			int mid = arr[(i+j)/2];
			
			while( i < j)
			{
				if(arr[i] >= mid)
				{
					
				}
			}
		}
		
		
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		
	}
}
