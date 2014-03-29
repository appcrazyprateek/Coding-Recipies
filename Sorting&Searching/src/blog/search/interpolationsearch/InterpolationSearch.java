package blog.search.interpolationsearch;

/*
 Interpolation search (sometimes referred to as extrapolation search) is an algorithm for searching for a given key value in an indexed array that has been ordered by the values of the key. It parallels how humans search through a telephone book for a particular name, the key value by which the book's entries are ordered. In each search step it calculates where in the remaining search space the sought item might be, based on the key values at the bounds of the search space and the value of the sought key, usually via a linear interpolation. The key value actually found at this estimated position is then compared to the key value being sought. If it is not equal, then depending on the comparison, the remaining search space is reduced to the part before or after the estimated position. This method will only work if calculations on the size of differences between key values are sensible.

By comparison, the binary search always chooses the middle of the remaining search space, discarding one half or the other, again depending on the comparison between the key value found at the estimated position and the key value sought. The remaining search space is reduced to the part before or after the estimated position. The linear search uses equality only as it compares elements one-by-one from the start, ignoring any sorting.

On average the interpolation search makes about log(log(n)) comparisons (if the elements are uniformly distributed), where n is the number of elements to be searched. In the worst case (for instance where the numerical values of the keys increase exponentially) it can make up to O(n) comparisons. 
 */

public class InterpolationSearch {

	private static int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
	public static void main(String[] args) {
		
		search(17);	
	}


	private static int search(int number) {
		int low=0;
		int high=arr.length-1;
		int mid=low;
		int count=0;
		
		while(arr[low]<=number && arr[high]>=number)
		{
			count++;
			mid=low+ ( (number-arr[low])*(high-low) )   /   (arr[high] -arr[low]);
			
			if(number > arr[mid])
				low=mid+1;
			else if(number < arr[mid])
				high = mid-1;
			else 
			{
				System.out.println("Nunber of Iterations: "+count);
				System.out.println("Number found at "+mid);
				return mid;
			}
			
			
		}
		System.out.println("Nunber of Iterations: "+count);
		System.out.println("Number not found");
		return -1;
		
	}
	
	
}
