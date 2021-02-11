/**
 * 
 */
package blog.array.movezeros;

import java.util.Arrays;

/**
 * @author rpratee
 *
 */
public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] result = moveZerosToEnd(new int[] { 0, 1, 2, 0, 3, 0, 0, 4, 0, 0, 0, 5 });
		System.out.println(Arrays.toString(result));
	}

	public static int[] moveZerosToEnd(int[] arr) {
		// Count counts the non-zero elements
		int i = 0, count = 0;
		int len = arr.length;
		
		String s = null;

		while (i < len) {
			if (arr[i] != 0) {
				if (i != count)
					swap(arr, i, count++);
			}

			i++;
		}
		return arr;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
