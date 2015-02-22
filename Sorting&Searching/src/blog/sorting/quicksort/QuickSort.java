package blog.sorting.quicksort;

public class QuickSort
{
	private static int[] arr={ 3,1,4,5,2 };
	
	//private static int[] arr={0,1,1,0,2,0,0,1,2,0,1,2};
	public static void quicksort(int low,int high)
	{
		int i = low, j = high;
		int pivot=low+(high-low)/2;
		//int pivot= low;

		while(arr[i] <= arr[pivot])
			i++;

		while(arr[j] >= arr[pivot])
			j--;

		if(i<=j)
		{
			swap(i,j);
			i++;
			j--;
		}

		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	static void swap(int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;

	}

	public static void main(String[] args) {
		quicksort(0,arr.length-1);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}


}
