package blog.sorting.shellsort;

import java.util.Arrays;
/**
 * Shell Sort, and extension of Insertion sort based on gap
 * @author rpratee
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {19, 9 , 11, 4, 2, 35, 13, 17, 25};
		System.out.println("Input  : " + Arrays.toString(arr));
		shellSort(arr);
		System.out.println("Output : " + Arrays.toString(arr));
	}
	
	/**
	 * @param arr Input Array
	 */
	public static void shellSort(int[] arr) {
		int n = arr.length;
		//continue until gap reduces from n/2 to 1, with value 1 , it is insertion sort
		// with this technique no. of swaps reduces. 
		for(int gap = n/2; gap >= 1; gap/=2)
		{
			//this variable is used to track the ending of the list and it starts from gap.
			for(int j=gap ; j < n ; j++)
			{
				//This loop is for comparisons between i and i+gap(and not i and j),
				for(int i = j - gap; i>=0 ; i-=gap)
				{
					if(arr[i+gap] < arr[i])
						swap(arr, i+gap , i);
					else //if there are no swaps, then this element is greater than all elements on the left of 
						//the array, so break the loop.
						break;
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
