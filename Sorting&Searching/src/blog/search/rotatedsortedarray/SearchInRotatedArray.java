package blog.search.rotatedsortedarray;
/**
 * Search in a roated Array
 * @author r.prateek
 */
public class SearchInRotatedArray {

	private int[] arr;  // the input array
	private static int index=-1;  // store the index of the element found
	public SearchInRotatedArray(int arr[])
	{
		this.arr=arr;
	}

	/**
	 * subroutine which uses modified binary search to find an element
	 * @param num : the number to be searched
	 */
	public void find(int num) {
		int index =binarySearch(num , 0 , arr.length -1 ) ;

		if(index != -1)
			System.out.println("Number found at position : "+ (index + 1) );
		else
			System.out.println("Not Found");
	}
   
	
	/**
    * Modified Binary Search to find element in a rotated array.
    * @param num : number to be searched 
    * @param low : lower index of the intermediate array
    * @param high :higher index of the intermediate array
    * @return : the index of the element found
    */
	private int binarySearch(int num, int low , int high) {

		int mid = ( low + high ) / 2 ;

		if(low <= high) {

			if(arr[mid] == num)
				return index=mid ;

			//Case 1  
			if((arr[low] > num)        && 		(arr[mid] > num )       && 	    (arr[high] > num ))
				binarySearch( num,  mid+1 ,  high) ;


			//Case 2
			else if((arr[low] < num)       &&		(arr[mid] < num )    &&	     (arr[high] < num ))
				binarySearch( num,  low ,  mid - 1) ;

			//Case 3
			//if((arr[low] > num)      &&		(arr[mid] > num )      &&	    (arr[high] < num ))
			if((arr[mid] < num )      &&	    (arr[high] > num ))
				binarySearch( num,  mid +1  ,  high) ;

			//Case 4
			else if((arr[low] < num)       &&		(arr[mid] > num ) )
				binarySearch( num,  low  ,  mid -1) ;

		}
		return index;
	}

	public static void main(String[] args) {
		int arr[]={ 6 , 7 , 8 , 9 , 1, 2, 3 , 4 , 5 } ;
		SearchInRotatedArray obj=new SearchInRotatedArray(arr);

		obj.find(1);
	}

}
