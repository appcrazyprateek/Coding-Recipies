package blog.search.binarysearch;



public class BinarySearch {

	private static int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};

static int mid;
	public static void main(String[] args) {
		binarySearch(17,0,arr.length-1);	
	}


	private static void binarySearch(int numberToFind,int low,int high) {
		int count=0;
		while(low<=high)
		{
			count++;
			int mid=(low+high)/2;
			if(arr[mid]==numberToFind)
			{
				System.out.println("Nunber of Iterations: "+count);
				System.out.println("Number found at "+mid);
				return ;
			}
			else if(arr[mid] < numberToFind)
			{
				low=mid+1;
			}
			else if (arr[mid] > numberToFind)
			{
				high=mid-1;
			}
		}
		System.out.println("Nunber of Iterations: "+count);
		System.out.println("Number not Found");
	}


	private static void binarySearchRecursion(int numberToFind,int low,int high) {

		if(high > low)
		{
			mid=(low+high)/2;
			if(numberToFind<arr[mid])
			{
				binarySearchRecursion(numberToFind,low,mid -1 );
			}
			else
			{
				binarySearchRecursion(numberToFind,mid+1,high);
			}
		}
		else
		{
			System.out.println("Key not Found");
			return ;
		}

	}


}
