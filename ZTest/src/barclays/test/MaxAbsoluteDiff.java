package barclays.test;

import java.util.Arrays;

public class MaxAbsoluteDiff {
	static int solution(int[] A)
	{
		int len = A.length; 
		int []lmaxArray = new int[len];
		int []rmaxArray = new int[len];
		
		int lmax = A[0];
		int rmax = A[len-1];
		for(int i=0,j=len-1;i<len && j>=0 ; i++,j--)
		{
			if(A[i] >= lmax)
				lmax = A[i];
			lmaxArray[i]=lmax;
			
			if(A[j]>=rmax)
				rmax = A[j];
			rmaxArray[j]=rmax;
		} 
		
		
		int max = -1;
		for(int i=0;i<len;i++)
		{
			 int diff = Math.abs(lmaxArray[i] - rmaxArray[i]);
			 max = diff > max ? diff : max ;
		}
		
		//System.out.println(Arrays.toString(lmaxArray));
		//System.out.println(Arrays.toString(rmaxArray));
		return max;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[]{4, 3, 2, 5, 1, 1}));
		System.out.println(solution(new int[]{1, 3, -3}));
	}	
	
}
