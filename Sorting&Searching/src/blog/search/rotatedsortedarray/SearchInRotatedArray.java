package blog.search.rotatedsortedarray;

/**
 * Search in a roated Array Modified Binary Search for sorted rotated array
 * @author r.prateek
 */
public class SearchInRotatedArray {

	public static int search(int[] arr, int num, int low, int high) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2;
			if (num == arr[mid])
				return mid;

			// First half of the array is sorted
			if (arr[start] < arr[mid]) {

				// Number is in first half
				if (arr[start] <= num && num < arr[mid])
					end = mid - 1;
				else // else number is in second half
					start = mid + 1;
			} else { // Second half is sorted

				// Number is in second half
				if (arr[mid] < num && num <= arr[end])
					start = mid + 1;
				else // else Number is in 1st half
					end = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 6, 7, 8, 9, 1, 2, 3, 4, 5 };
		search(arr, 7, 0, arr.length - 1);
	}
}
