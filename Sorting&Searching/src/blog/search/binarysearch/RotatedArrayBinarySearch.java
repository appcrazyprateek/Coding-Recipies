package blog.search.binarysearch;
public class RotatedArrayBinarySearch {

	public static void main(String args[]){
		int a[] = {4, 5, 6, 7, 1, 2, 3};
		int key = 7;

		System.out.println("The array currently looks like");
		for (int i=0; i<a.length; i++)
			System.out.println(a[i]);	

		//System.out.println("Found " + key + " at " + binarySearch(a, key));
	}

	 int search(int[] arr, int data) {
		if(arr== null)
			return -1;
		
		int low = 0;
		int high = arr.length -1;
		int mid = 0;;
		while (low<=high) 
		{
			mid = (low+high) /2;

			if(arr[mid] == data)
				return mid;
			
			if (arr[mid] < data)
			{
				if((arr[high]>data))
					low = mid + 1;
				else if(arr[high]<data)
					high = mid - 1;
				else
					return high;
			}
			else if(arr[mid] > data)
			{
				if(arr[low]<data)
					high = mid-1;
				else if(arr[low]>data)
					low = mid + 1;
				else
					return low;
			}
		}
		return -1;
	}
}