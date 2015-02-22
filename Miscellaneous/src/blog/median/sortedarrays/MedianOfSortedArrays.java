package blog.median.sortedarrays;
/**
 * Finds middle element
 * @author PRATEEK
 *
 */
public class MedianOfSortedArrays {
	
	public static int[] arr2 = {900}; // {3, 7 , 9 , 17 , 31, 36 , 47, 51 , 58} ;
	public static int[] arr1 = {5, 8, 10, 20}; //{2, 15 , 18 , 28 , 45, 49 , 54} ;
	
	
	public static void main(String[] args) {
		
		System.out.println(compute(0,arr1.length - 1, 0,arr2.length -1 ));
	}

	
	public static int compute(int low1, int high1, int low2 , int high2){
		
		int index1 = (low1 + high1)/2 ; 
		int m1 = arr1[index1] ;
		
		int index2 = (low2 + high2)/2 ;
		int m2 = arr2[index2] ;
		
		if(high1 <= low1)
			return m1;
		
		if(high2 <= low2)
			return m2;
		
		if(m1 == m2){
			return arr1[m1];
		}
		if(m1 > m2)
		{
			//return compute(low1, index1 -1 , index2 +1  , high2   );
			return compute(low1, index1 , index2 , high2   );
		}
		else {
			//return compute(index1 +1 , high1, low2 , index2 -1   );
			return compute(index1 , high1, low2 , index2   );
		}
	}
}
