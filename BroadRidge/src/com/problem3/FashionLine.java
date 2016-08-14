package com.problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FashionLine {

	
	 public static void main(String args[] ) throws Exception {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) {
	        	
	        	String[]  line1 = br.readLine().split("\\s+");
	            int n = Integer.parseInt(line1[0]);
	            int k = Integer.parseInt(line1[1]);
	            int l = Integer.parseInt(line1[2]);
	            int r = Integer.parseInt(line1[3]);
	            
	            String str = br.readLine();
	            String pat = br.readLine();
	        }
	    }

	 private void findCount(String str, String  pat, int n, int k, int l, int r) {
		 int strLen = str.length();
		 int patLen = pat.length();
		 
		 Map<String, Integer> toFind = new HashMap<String, Integer>(); 
		  // the set of  words  which are found
		 Map<String, Integer> found = new HashMap<String, Integer>();
		 
		 
		 
		 for(int i=0;i<strLen;i++)
		 {
			 
		 }
	   }

	 
	 
	 public void test()
	 {
		 int[] arr = {0,3,6};
		 int n = 8;
		// int s = 0;
		// int f = 0;
		 int l=1 ;
		 int r =2 ;
		 int c = 0;
		 for(int s=0,f=0;f<n ;)
		 {
			 if((f-s+1 >= l) &&  (f-s + 1 <= r) )
			 {
				 c += arr[f]-arr[s];
				 f++;
			 }
			 else if( f-s + 1 > r )
			 {
				c += arr[f] - arr[f-1] - 1;
				s++;
			 }
				 
		 }
	 }

}
