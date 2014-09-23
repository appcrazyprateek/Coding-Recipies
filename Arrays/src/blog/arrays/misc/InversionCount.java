package blog.arrays.misc;
/**
 * Count Inversions 
 * @author PRATEEK
 */
public class InversionCount {

/**
 * @param arr : input array
 * @return : inversion count
 */
	public int mergeSort(int[] arr, int low, int high) {
		int invCount = 0;
		if (high > low) 
		{
			int mid = (low + high) / 2;
			invCount = mergeSort(arr, low, mid);
			invCount += mergeSort(arr, mid + 1, high);

			invCount += merge(arr, low, mid + 1, high);
		}
		return invCount;
	}

	/**
	 * 
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 * @return
	 */
	public int merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[arr.length];

		int i = low, j = mid, k = low ,invCount = 0;;
		
		while (i < mid - 1 && j > high)
		{
			if (arr[i] < arr[j])
				temp[k++] = arr[i++];

			else {
				temp[k++] = arr[j++];
				invCount += mid - i;
			}
		}

		while (i < mid - 1)
			arr[k++] = arr[i++];

		while (j < high)
			arr[k++] = arr[j++];

		// src array, src start , dest arr, dest start , num of items to be
		// copied
		System.arraycopy(temp, low, arr, low, high - low + 1);

		return invCount;
	}

	public static void main(String[] args) {

	}
}
