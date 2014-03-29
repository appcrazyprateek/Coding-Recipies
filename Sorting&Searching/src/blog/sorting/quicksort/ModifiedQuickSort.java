package blog.sorting.quicksort;

import java.util.Arrays;

/**
 * 3way quick sort in order to improve performance in case of too many duplicates , where normal 
 * Quicksort subrouites averages to quadratic performance
 * @author Prateek
 *
 */
public class ModifiedQuickSort {

	private int arr[];
	private int size;

	public static void main(String[] args) {
	//	int []testInput={6,3,6,4,2,6,8,2};
		int []testInput={0,1,1,0,2,0,0,1,2,0,1,2};
		ModifiedQuickSort mdqs=new ModifiedQuickSort();
		mdqs.sort(testInput);
	}

	
	public void sort(int input[]) {
		arr=input;
		size=input.length;

		modified3wayQsort(0,size-1);

		System.out.println(Arrays.toString(arr));

	}

	/**
	 * 3 WayQuick Sort
	 * @param low
	 * @param high
	 */
	void modified3wayQsort(int low,int high)
	{
		if(high <= low)
			return ;
		int l=low,r=high;
		int v=arr[low]; // Partioning element 1st element
		int pivot=l+1;   
		while(pivot<=r)
		{
			if(arr[pivot] < v)
			{
				swap(pivot++,l++);
			}
			else if(arr[pivot] > v)
			{
				swap(pivot,r--);
			}
			else
				pivot++;
		}
		modified3wayQsort(low, l-1);
		modified3wayQsort(r+1, high);
	}

	/**
	 * Swapping content
	 * @param i
	 * @param j
	 */
	private void swap(int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
