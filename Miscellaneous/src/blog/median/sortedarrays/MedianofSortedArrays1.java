package blog.median.sortedarrays;

public class MedianofSortedArrays1 {

	public int median(int arr[] , int len){

		if(len % 2 == 0)
			return (arr[len/2] + arr[len/2 - 1])/2 ;

		return arr[len/2];
	}


	/*public int getMedian(int[] arr1 , int[] arr2 , int len){
		if(len==0)
			return -1;
		if(len == 1)
			return (arr1[0] + arr2[0])/2 ;
		if(len == 2)
			return (max(arr1[0],arr2[0]) + min(arr1[0] , arr2[0]) )/2 ;

		else
		{
			int med1 , med2;

			med1 = median(arr1, len);
			med2 = median(arr2, len);

			if(med1 == med2){
				return med1;
			}
			else if(med1 < med2)
			{
				//return getMedian(arr1+n/2, arr2, len - len/2);
				return getMedian(arr1, arr2, len - len/2);
			}
			else
				return getMedian(arr1, arr2, len - len/2);
		}
	}
	 */

	public int getMedianBinarySearch(int[] arr1 , int l1 , int h1 , int[] arr2 , int l2 , int h2){

		int mid1= (h1 + l1) /2 ;
		int mid2 = (h2 + l2) /2 ;

		if(h1-l2 ==1 )
			return (Math.max(arr1[l1], arr2[l2]) + Math.min(arr1[h1], arr2[h2]))/2;
		else if(arr1[mid1] > arr2[mid2])
			return getMedianBinarySearch(arr1 ,l1 , mid1 , arr2 ,mid2 , h2);
		else
			return getMedianBinarySearch(arr1 ,l1 , mid1 , arr2 ,mid2 , h2);
	}
	
	public int  getmedian(int[] arr1 , int[] arr2)
	{
		return getMedianBinarySearch(arr1 ,0 , arr1.length -1  , arr2 ,0 , arr1.length -1);
	}
}
