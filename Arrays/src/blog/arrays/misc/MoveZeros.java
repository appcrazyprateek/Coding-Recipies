package blog.arrays.misc;

import java.util.Arrays;

/**
 * Move Zeros to the End of the array
 * @author PRATEEK
 */
public class MoveZeros {

	/**
	 * @param arr
	 * @return
	 */
	public int[] moveZeros(int[] arr) {
		int count = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				count++;
				swap(arr, count, i);
			}
		}
		return arr;
	}

	/**
	 * Using Quick Sort Subroutine, when i point non-zero and j point 0 , swap
	 */
	public int[] moveUsingMerge(int[] arr) {
		int i = 0, j = arr.length - 1;

		while (i < j) {
			
			while (arr[i] != 0 && i < j) { i++;	}

			while (arr[j] == 0 && i < j) { j--;	}

			swap(arr, i, j);
		}
		System.out.println(Arrays.toString(arr));
		return arr;

	}

	private void swap(int[] arr, int i, int j) {
		if (arr != null && i != j && i > -1 && j > -1) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 1, 3, 0, 0, 4, 0, 0, 0 };
		MoveZeros obj = new MoveZeros();
		// arr=obj.moveZeros(arr);
		arr = obj.moveUsingMerge(arr);
		System.out.println(Arrays.toString(arr));

	}

}
