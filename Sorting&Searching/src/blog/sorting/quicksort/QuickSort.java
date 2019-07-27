package blog.sorting.quicksort;

public class QuickSort {
	//private static int[] arr = { 3, 1, 4, 5, 2 };
	private static int[] arr = { 10, 80, 30, 90, 40, 50, 70 };

	/**
	 * 3 WayQuick Sort
	 * 
	 * @param low
	 * @param high
	 */
	static void modified3wayQsort(int low, int high) {
		if (high <= low)
			return;

		int pivot = partition3(arr, low, high);

		modified3wayQsort(low, pivot - 1);
		modified3wayQsort(pivot + 1, high);
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[low]; // Partioning element 1st element
		int i = low + 1;
		while (i <= high) {
			if (arr[i] < pivot) {
				swap(i++, low++);
			} else if (arr[i] > pivot) {
				swap(i, high--);
			} else
				i++;
		}
		return i;
	}

	//TODO small bug, correct it, test on { 10, 80, 30, 90, 40, 50, 70 }
	public static int partition2(int arr[], int low, int high) {
		int pivot = arr[low + ((high - low) / 2)];

		while (low != high) {

			if (arr[low] < pivot)
				low++;
			else {
				swap(low, high);
				high--;
			}
		}
		return high;
	}

	private static int partition3(int[] arr, int low, int high) {
		int i = low;
		int j = high + 1;
		int pivot = arr[low];
		while (true) {

			//motive to find a element greater than pivot, then stop
			while (arr[++i] < pivot) {
				if (i == high)
					break;
			}

			// motive to find a element smaller than pivot, then stop
			while (pivot < arr[--j]) {
				if (j == low)
					break;
			}

			// in case pointers cross
			if (i >= j)
				break;

			swap(i, j);
		}

		//swap pivoted element with j
		swap(low, j);

		return j;
	}

	public static void main(String[] args) {
		modified3wayQsort(0, arr.length - 1);
		// partition2(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
