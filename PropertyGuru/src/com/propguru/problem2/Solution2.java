package com.propguru.problem2;
/**
 * Problem Number 2 , Property GURU
 * 	@author prathore2
 */
public class Solution2 {

	
	public static void main(String[] args) {
		int[] A = {9,4,-3,-10};
		Solution2 s = new Solution2();
		int val = s.solution(A);
		System.out.println(val);
	}
	
	public int solution(int[] A) {
		long avg = 0,maxDeviation = -1;
		int N = A.length, maxDeviationIndex = -1;
		
		for(Integer i : A)
			avg += i/N;
		
		for (int i = 0; i < N; i++) {
			long deviation = Math.abs(avg - A[i]);
			
			if (deviation > maxDeviation) {
				maxDeviationIndex = i;
				maxDeviation = deviation;
			}
		}
		return maxDeviationIndex;
	}
}
