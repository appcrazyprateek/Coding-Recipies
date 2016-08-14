package com.zinio;
/**
 * Solution 2
 * @author prathore2
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		int[] A = {1, 1, 0, 1, 0, 0, 1, 1} ;
		Solution s = new Solution();
		System.out.println(s.solution(A));
	}
	
	 public int solution(int[] A) {
		 if(A!=null)
		 {
			 int max = Integer.MIN_VALUE;
			 int sum =  calcSum(A);
				int len = A.length;
				for(int i=0,curr=0;i<len;i++)
				{
					curr =0;
					if(i!=0 && i!=len-1)
					{
						if(A[i-1]==A[i+1])
							continue;
						else 
							if(A[i]!=A[i-1])
								curr = curr+2;
							else
								curr = curr-2;
						
					}
					else
					
						if(A[0]==A[1] || A[len-1]==A[len-2])
							curr-=1;
						else
							curr+=1;
					if(max < curr)
						max = curr;
				}
				 return sum+max;
		 }
		return 0;
	    }

	private int calcSum(int[] A) {
		int sum =  0;
		for(int i=0;i<A.length-1;i++)
		if(A[i]==A[i+1])
		sum++;
		return sum;
	}
}
