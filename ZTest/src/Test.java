/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Test
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String s1 = "bddcc";
		String s2 = "ccadd";
		
	    int count = maxRotation(s1, s2); 
	    System.out.println(count);
	}
	
	private static int maxRotation(String s1, String s2) {
	    
	    int len = s2.length();
	    int max = Integer.MIN_VALUE;
	    int index = 0;
	    
	    for(int i=0;i<len;i++) {
	       int count =    getMatchingCount(s1, s2, i, 0);
	       if(count > max) {
	            max = count ;
	            index = i;  
	       }
	    }
	    
	    return Math.min(index, len - index);
	}
	
	private static int getMatchingCount(String s1, String s2, int i, int j) {
		
	    int count = 0;
	    int len = s1.length();
	    for(;i<len;i++) {
	        if(s1.charAt(i) == s2.charAt(j)) {
	            count ++;
	            j++;
	            i = (i+1)%len;
	        }
	        return count; 
	        	
	    }
	    return count;
	}
}
