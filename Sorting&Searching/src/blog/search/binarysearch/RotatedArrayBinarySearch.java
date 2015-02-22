package blog.search.binarysearch;
public class RotatedArrayBinarySearch {

	public static void main(String args[]){
		int a[] = {4, 5, 6, 7, 1, 2, 3};
		int key = 7;

		System.out.println("The array currently looks like");
		for (int i=0; i<a.length; i++)
			System.out.println(a[i]);	

		System.out.println("Found " + key + " at " + binarySearch(a, key));
	}

	public static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length -1;
		int mid = 0;;
		while (low<=high) {
			mid = (low+high) /2;

			if(a[mid] == key){
				return mid;
			}

			if (a[mid] < key){
				if((a[high]>key)){
					low = mid + 1;
				}else if(a[high]<key){
					high = mid - 1;
				}else{
					return high;
				}
			}else if(a[mid] > key){
				if(a[low]<key){
					high = mid-1;
				}else if(a[low]>key){
					low = mid + 1;
				}else{
					return low;
				}
			}

		}
		return -1;
	}
}