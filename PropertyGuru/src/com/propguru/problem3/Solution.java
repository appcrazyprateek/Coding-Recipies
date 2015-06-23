package com.propguru.problem3;
/**
 * Problem Number 3 , Property GURU
 * 	@author prathore2
 */
public class Solution {
	public static void main(String[] args) {
		int[] A = {5,4,-3,2,0,1,-1,0,2,-3,4,-5};
		Solution s = new Solution();
		int val = s.solution(A);
		System.out.println(val);
	}
	
	public int solution(int[] A) {
		
		int maxCount = 0;
		int count = 0;
		boolean prev = false;
		boolean curr = isPositive(A[0]);
		
		for(int i=1;i<A.length;i++)
		{
			 prev = curr;
			 curr = A[i]==0 ? !prev : isPositive(A[i]);
			
			if(prev != curr)
			{
				count++;
				if(maxCount < count)
					maxCount = count ;
			}
			else 
			{
				count = 0;
			}
				
		}
		 return maxCount;
	}
	
	public boolean isPositive(int num)
	{
		if(num>0)
			return true;
		return false;
	}
}
