package com.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestClass {

	
	 public static void main(String args[] ) throws Exception {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        Map<Character, Long> map =  new HashMap<Character,Long>(7);
	        line = br.readLine();
	        for (int i = 0; i < N; i++) {
	        	Character c = line.charAt(i);
				 Long count = map.get(c);
				 if(count == null)
					 map.put(c,1l);
				 else
					 map.put(c,count+1); 
	        }
	        
	        int k = Integer.parseInt(br.readLine());
	        for (int i = 0; i < k; i++) {
	        	printSolution(map, br.readLine());
	        }
	    }
	 
	 private static void printSolution(Map<Character, Long> map,String line) {

		 long product  = 1;  
		 int len =  3; // constant value 
		 for(int i=0;i<len;i++)
		 {
			 Character c = line.charAt(i);
			 Long count = map.get(c);
			 if(count==null || count == 0)
			 {
				 count = 0l;
				 product = 0;
				 System.out.println(0);
				 return;
			 }
			 product *=count; 
		 }
		 System.out.println(product);
		 // Remove Entries
		 if(product!=0)
		 {
			 for(int i=0;i<len;i++)
			 {
				 Character c = line.charAt(i);
				 Long count = map.get(c);
				 map.put(c, count - 1);
			 }
		 }
	}
}
