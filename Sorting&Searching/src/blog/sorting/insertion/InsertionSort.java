package blog.sorting.insertion;
/**
 * Insertion Sort Implementation
 * @author Prateek
 */
public class InsertionSort {
	/**
	 * Insertion Sort Subroutine
	 */
	public int[] insertionSort(int[] arr)
	{
		int size = arr.length;
		for(int i=1;i<size;i++){
			int j=i;
			int num=arr[i];
			while(j>0 && arr[j-1] > num){
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=num;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[]={1,5,4,7,3,12,5,9,2,8};
		
		InsertionSort obj= new InsertionSort();
		System.out.println("Before Sorting:");
		obj.display(arr);
		
		int[] sorted=obj.insertionSort(arr);
		System.out.println("After Sorting:");
		obj.display(sorted);
	}
	
	/**
	 * Display Array
	 */
	public void display(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
}
