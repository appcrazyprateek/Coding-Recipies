package blog.dp.lis;

import java.util.Arrays;
/**
 * Longest Increasing Sub-Sequence
 * @author Prateek
 */
public class LongestIncreasingSubsequence {

	private static int[] LIS;  
	private static int[] sol; //Array to retrive the sequence
	static int tail=0;   //final element of sequence

	/**
	 * Procedure to find LIS
	 * @param arr : input array
	 * @return longest value on increasing sub sequence
	 */
	public static int lis(int[] arr){
		int len = arr.length ;

		LIS = new int[len];
		sol = new int[len] ; 

		Arrays.fill(sol, -1);

		LIS[0] = 1; //base case
		int MAX_LIS=1;  // default value
		int max; // gets max value for each i
		for(int i=1;i < len ; i++)
		{
			max=0;
			for(int j=0 ; j<i ; j++)
			{
				if(arr[i] > arr[j] && LIS[j] > max )
				{
						sol[i] = j ; //used to save
						max = LIS[j]; //update max for value of i
				}
			}
			LIS[i] = 1 + max ;

			if(LIS[i] > MAX_LIS){
				MAX_LIS = LIS[i];
				tail=i;
			}
		}

		printSequence(sol, arr);
		System.out.println("Sequence length : " + MAX_LIS);
		return MAX_LIS ;
	}

	
	public static void printSequence(int[] sol , int[] arr){
		System.out.println("Sequence : ");
		for (int j = tail; j >= 0; j = sol[j])
			System.out.print(arr[j]+"\t");
		
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {3, 2 , 7 , 3 , 4 , 9 , 8 , 12 , 5};
		lis(arr);
	}
}