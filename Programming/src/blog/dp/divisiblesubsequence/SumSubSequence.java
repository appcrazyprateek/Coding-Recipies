package blog.dp.divisiblesubsequence;

/**
 * Continuos Sub-Sequence divisible by a number
 * @author Prateek
 */
public class SumSubSequence {

	public static void main(String[] args) {
		//int[] arr={1, 1, 9 , 7, 12 , 5 , 8 , 2, 7, 2, 10, 2, 3}; 
		//int divisor=13;
		int[] arr={1 , 1 , 3 , 2 , 4, 1 ,4 , 5};
		int divisor=5;
		solve(arr,divisor);
	}

	/**
	 * Sub-Routine to count numnber of sub-sequnces
	 * @param d: the given divisor
	 */
	public static int solve(int[] arr, int d)
	{
		Object o;
		int Answer = 0;
		int[] hash = new int[d];

		int sum = 0;
		int val;
		int num;

		for (int i = 0; i < arr.length; i++) {
			num = arr[i];

			if(num % d == 0) // counte numbes which are divisible by divisor
				Answer ++ ;

			sum +=  num; 
			val = sum % d;

			if(val<0) //handle negative numbers
				val = val * (-1);

			hash[val] = hash[val] + 1;
		}

		int size=hash.length ;
		for (int i = 0; i < size; i++) 	{
			int count = hash[i];

			if(count > 1)
				Answer = Answer + count * (count -1)/2 ;
		}
		System.out.println(Answer+hash[0]);
		return Answer+hash[0];
	}	
}
