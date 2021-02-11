package blog.sorting.mergesort;

import java.util.Arrays;

/**
 * MergeSort using recursive and non recursive calls (bottom up mergesort)
 * @author Prateek
 */
public class MergeSort {
	int arr[];
	int size;
	public static void main(String[] args) {
		int []testInput={6,3,7,1,5,4,9,8,2};
		MergeSort m=new MergeSort();
		m.sort(testInput);
	}

	/**
  * 
  * @param values
  */
	public void sort(int values[]) {
	
		this.arr=values;
		this.size=arr.length;
		
		//TODO : uncomment if  recursive call required
		//mergeSort(0, size-1);  // recusive call
		
		bottomUpMergeSort();     // Non recursive call
		
		
		System.out.println("Sorted Array : " +Arrays.toString(arr));
	}

	/**
	 * 
	 * @param low
	 * @param high
	 */
	private void mergeSort(int low, int high) {
		
		if (low < high) {
			int mid = low + (high - low) / 2;
			
			mergeSort(low, mid);
			
			mergeSort(mid + 1, high);
			
			merge(low, mid, high);
		}
	}

	/**
	 * Non recursive merge sort
	 */
	private void bottomUpMergeSort()
	{
		// number of elements to be considered, and it doubles in the next pass
		for(int len=1;len<size ; len=len+len)
		{
			// for a given number of items traverse in pairs to call merge subroutine
			for(int index=0;index< size- len; index += len+len)
			{
				merge(index, index+len -1, Math.min(index + len + len -1 , size -1 ));
			}
		}
	}
	
	/**
	 * Merge Subroutine 
	 * @param low : lower index of the array
	 * @param middle : Middle index of the array
	 * @param high : Last index of the array to be sorted
	 */
	private void merge(int low, int middle, int high) {
		int i=low; // initial index of 1st part of array
		int j=middle+1; // initial index of 2nd part of array
		
		int k=0;  // index for auxillay array
		
		int temp[]=new int[size]; //auxillay Array
		
		// Copying the smalller of the two elements int the two parts
		while(i<=middle && j<=high)
		{
			if(arr[i] < arr[j])
			{
				temp[k]=arr[i];
				i++;
			}
			else
			{
				temp[k]=arr[j];
				j++;
			}
			k++;
		}
		
		// simply 1st part of array copying if 2nd part gets exausted
		while(i<=middle)
		{
			temp[k]=arr[i];
			i++;
			k++;
		}
		
		// simply 2nd part of array copying if 1st part gets exausted
		while(j<=high)
		{
			temp[k]=arr[j];
			j++;
			k++;
			String s = null;
		}

		// copying content from auxillay array to the original array
		k=0;
		while(low<=high)
		{
			arr[low]=temp[k];
			k++;
			low++;
		}
		Arrays.sort(a);
	}
} 