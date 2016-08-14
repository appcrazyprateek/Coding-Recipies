package blog.sorting.dutchflag;

import java.util.Arrays;

/**
 * http://www.csse.monash.edu.au/~lloyd/tildeAlgDS/Sort/Flag/
 * @author prathore2
 *
 */
public class DutchFlagProblem {

	
	public static void main(String[] args) {
		int[] arr = {1,2,0,2,0,1,0,2};
		int[] out = sort(arr);
		System.out.println(Arrays.toString(out));
	}

	private static int[] sort(int arr[]) {
		if (arr != null) {
			int len = arr.length;
			int low = 0;
			int mid = 0;
			int high = len - 1;

			while (mid <= high) {
				switch (arr[mid]) {
				case 0:
					swap(arr, mid++, low++);
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(arr, mid, high--);
					break;
				}
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
