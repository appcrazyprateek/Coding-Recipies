package blog.sorting.basic;


public class BasicSorting {
	static int arr[]={1,5,4,7,3,12,5,9,2,8};
	public static void main(String[] args) {
		
		System.out.println("Before Sorting:");
		display(arr);
		//int[] arr=insertionSort(arr);
		bubbleSort();
		selectionSort();
		System.out.println("After Sorting");
		display(arr);

	}
	public static int[] insertionSort(int[] arr)
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


	public static void display(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}

	public static void bubbleSort()
	{
		for(int i=arr.length;i>1;i--)
		{
			for(int j=0;j<i;j++) 
			{
				if(arr[j] > arr[j+1]) 	swap(j,j+1);
			}
		}
	}

	public static void selectionSort()
	{
		for(int i=0;i<arr.length ; i++)		      
		{
			for(int j=i+1;j<arr.length ; j++)	
			{
				if(arr[i] > arr[j])	    swap(i,j);
			}
		}
	}

	public static void swap(int a, int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
