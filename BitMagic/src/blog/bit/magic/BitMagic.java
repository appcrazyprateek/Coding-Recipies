package blog.bit.magic;

public class BitMagic {

	public static void main(String[] args) {
		//int count = countSetBits(00000101);
		//int singleNumber = singleNumber(new int[] {1, 2, 2, 3, 1});
		
		//int singleNumber2 = singleNumber2(new int[] {5, 5, 4, 8, 4, 5, 8, 9, 4, 8} , 3);
		
		int result = singleNumber1(new int[] {1, 2, 2, 3, 1} );
		
		System.out.println(result);
		//System.out.println(1 << 0);
	}
	
	
	static int singleNumber1(int[] arr) {
		int result = 0;
		for(int val : arr) {
			result ^= val; 
		}
		return result;
	}

	public static int singleNumber2(int[] arr, int N) {
		int result = 0;
		int len = arr.length;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < len; j++) 
				sum += (arr[j] >> i) & 1;
			sum = sum % N;
			result |= sum << i;
		}
		return result;
	}
	
	
	//https://www.interviewbit.com/problems/single-number/
	public static int singleNumber(int[] arr) {
		int result = 0;
		for(int i: arr) 
			result ^= i;
		
		return result;
	}
	
	public static int countSetBits(long num) {

		int count = 0;
		while (num > 0) {
			if ((num & 1) != 0)
				count++;
			num >>= 1;
		}
		return count;
	}
}
