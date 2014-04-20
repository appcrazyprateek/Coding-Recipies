package blog.arrays.equilibriumIndex;

/**
 * Find the index in an array where sum to left is equal to sum to its right
 * @author PRATEEK
 */
public class EquilibriumIndex {

	/**
	 * @param arr: input arr
	 * @return : equilibrium index in the array
	 */
	private int equilibrium(int[] arr) {
		int i = 0, sum = 0, rightSum = 0;
		for (; i < arr.length; sum += arr[i++]);

		for (i--; i > 0; sum -= arr[i], rightSum += arr[i])
			if (sum == rightSum - arr[i--])
				return i;

		return -1;
	}

	public static void main(String[] args) {

		int arr[] = { -7, 1, 6, 2, -4, 3, 1 };
		EquilibriumIndex obj = new EquilibriumIndex();
		int mid = obj.equilibrium(arr);
		System.out.println(mid);

	}
}
