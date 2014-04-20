package blog.maxrepeatingnumber;

/**
 * Find the element with maximum frequency
 * @author PRATEEK
 */
public class MaxRepeatingNumer {
	public static void main(String[] args) {

		int arr[] = { 3, 1, 3, 2, 1, 2, 2 };
		int x = 5;
		System.out.println(maxRepeatingNumer(arr, x));
	}

	private static int maxRepeatingNumer(int arr[],int k) {
		
		int i = 0, max = arr[0], result = 0;
		for (; i < arr.length; i++)
			arr[arr[i] % k] += k;

		i = 1;
		for (; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			}
		}

		i = 0;
		for (; i < arr.length; i++)
			arr[i] = arr[i] % k;

		return result;
	}
}
