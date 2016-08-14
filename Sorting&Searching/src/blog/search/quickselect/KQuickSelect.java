package blog.search.quickselect;

/**
 * Finds the K-th Smallest elements in an array using Quick Select Technique
 * @author prathore2
 */
public class KQuickSelect {

	public int findKSmallest(Integer[] arr, int k, int l, int r) {
		int len = arr.length;
		int index = 0;
		if (k > 0 && k <= len) {
			 index = partition(arr, l, r);
			if (index + 1 == k) 
				return arr[index];
			else if (index < k)
				return findKSmallest(arr, k, index + 1, r);
			else
				return findKSmallest(arr, k, l, index - 1);
		}
		return arr[index ];
	}
	
	private int partition(Integer[] arr, int l , int r){
		int pivotValue = arr[r];
		int storeIndex=l,i=l;
		for (;i < r; i++ ) {
			if (arr[i] <= pivotValue) 
				swap(arr, i, storeIndex++);
		}
		if(arr[storeIndex] > arr[r])
			swap(arr, r, storeIndex);
		
		return storeIndex;
	}
	
	private void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] arr = { 7 , 5 , 4 , 3, 2, 8 , 1};
		int k = 7;
		KQuickSelect sortObj = new KQuickSelect();
		int data = sortObj.findKSmallest(arr, k, 0, arr.length-1);
		System.out.println(data);
	}
}
