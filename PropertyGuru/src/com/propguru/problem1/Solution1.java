package com.propguru.problem1;
 
/**
 * Problem Number 1 , Property GURU
 * @author PRATEEK
 *
 */
public class Solution1 {

	public static void main(String[] args) {
		Solution1 s  = new Solution1();
		s.solve(17,17);
		System.out.println(answer);
	}
	
	private static int answer = -1;
	 public int solution(int N) {
		solve(N,N);
		return answer;
	 }
	 
	private int solve(int N,int n)
	 {
		 if(n==0)
			 return 0;
		 
		 int val = solve(N ,n-1  )+n ;
		 if(val < N)
			 answer = n;
		 return val;
	 }
}
