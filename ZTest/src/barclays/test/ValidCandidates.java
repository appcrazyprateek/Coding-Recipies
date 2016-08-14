package barclays.test;

import java.util.Arrays;

public class ValidCandidates {

	static int solution(int[] A)
	{
		int N = A.length;
		 int[] temp =  new int[N];
		 System.arraycopy(A, 0, temp, 0, N);
		 Arrays.sort(temp); 
		 int index_array[] = new int[N];

		 for(int i=0; i<N; i++)
			 index_array[i] = Arrays.binarySearch(A,temp[i]); 
	
		 int max = -1;
		 
		 System.out.println(Arrays.toString(index_array));
		 System.out.println(Arrays.toString(A));
		 System.out.println(Arrays.toString(temp));
		 for(int i=0;i<N-1;i++)
		 {
			 int diff = Math.abs(A[i] - A[i+1]);
			 max = diff > max ? diff : max ;
		 }
	//	 System.out.println(max);
		return max;
	}
	
	public static void main(String[] args) {
	  solution(new int[]{1, 4, 7, 3, 3, 5});
	}	
	
}
