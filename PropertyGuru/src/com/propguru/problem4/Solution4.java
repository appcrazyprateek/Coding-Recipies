package com.propguru.problem4;
/**
 * Problem Number 4 , Property GURU
 * 	@author prathore2
 */
class Solution4 {
	
	public static void main(String[] args) {
		//int[] A = {1, 1, 3} ; int K = 2;
		int[] A = {1, 1, 2, 3, 4} ; int K = 3;
		//int[] A = {1, 1, 2, 3, 3} ; int K = 3;
		//int[] A = {1, 1, 2, 1, 3, 3} ; int K = 3;
		
		Solution4 s  = new Solution4 ();
		boolean val  = s.solution(A, K);
		System.out.println(val);
	}
	
    public boolean solution(int[] A, int K) {
    	 int n = A.length;
         for (int i = 0; i < n - 1; i++) {
        	 if (A[i] + 1 < A[i + 1])
                 return false;     
         }
         //if (A[0] != 1 && A[n - 1] != K)
         if (A[0] != 1 || A[n - 1] != K)
             return false;
         else
             return true;
    }
}
