package blog.search.binarysearch;

public class BinarySearch {

	private static int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};

	static int mid;
	public static void main(String[] args) {
		binarySearch(17,0,arr.length-1);	
	}


	private static int binarySearch(int numberToFind,int low,int high) {
		int count=0;
		while(low<=high)
		{
			count++;
			int mid=(low+high)/2;
			if(arr[mid]==numberToFind)
			{
				System.out.println("Nunber of Iterations: "+count);
				System.out.println("Number found at "+mid);
				return mid;
			}
			else if(arr[mid] < numberToFind)
				low=mid+1;
			else if (arr[mid] > numberToFind)
				high=mid-1;
		}
		System.out.println("Nunber of Iterations: "+count);
		System.out.println("Number not Found");
		return -1;
	}


	private static int binarySearchRecursion(int num,int low,int high) {

		if(high >= low)
		{
			mid=(low+high)/2;
		
			if(arr[mid] == num)
				return mid;
			else if(num<arr[mid])
				return binarySearchRecursion(num,low,mid -1 );
			else
				return binarySearchRecursion(num,mid+1,high);
		}
		return -1;
	}
}
