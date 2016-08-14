package blog.median.sortedarrays;

import java.util.Arrays;

public class MedianOfSortedArrays2 {

	static int median(int A[], int B[], int low, int high, int n, int m) 
	{
		if (low > high)
			return median(B, A,
					Math.max(0, (n+m)/2 - n),Math.min(m,(n+m)/2), m, n);
		
		int i = (low + high) / 2;
		int j = (n + m) / 2 - i - 1;
		
		if (j >= 0 && A[i] < B[j])
			return median(A, B, i + 1, high, n, m);
		
		else if (j < m - 1 && A[i] > B[j + 1])
			return median(A, B, low, i - 1, n, m);
		
		else 
		{
			if ((n + m) % 2 == 1)
				return A[i];
			
			
			if (i > 0 )
				return (A[i] + Math.max(B[j], A[i - 1])) / 2;
					
				return (A[i] + B[j]) / 2;
		}
	}

	static int medianOfSortedArrs(int A[], int n, int B[], int m) {
		if (n < m)
			return median(A, B, 0, n - 1, n, m);
		else
			return median(B, A, 0, m - 1, m, n);
	}
	
	
public static void main(String[] args) {
		
		testCase1();
		
	}
	
	public static void testCase1()
	{
		System.out.println("Test Case 1 : ");
		int[] A = {10};
		int[] B = {3,4,6} ;
		int med=medianOfSortedArrs(A, A.length, B, B.length);
		System.out.println("A : " + Arrays.toString(A)  + "   B : "+Arrays.toString(B) + "  Median :"+med);
		System.out.println("\n");
	}
	
	public static void testCase2()
	{
		System.out.println("Test Case 1 : ");
		int[] A = {10};
		int[] B = {3,4,6} ;
		int med=medianOfSortedArrs(A, A.length, B, B.length);
		System.out.println("A : " + Arrays.toString(A)  + "   B : "+Arrays.toString(B) + "  Median :"+med);
		System.out.println("\n");
	}
}
