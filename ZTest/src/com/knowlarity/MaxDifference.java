package com.knowlarity;

import javax.management.MXBean;

public class MaxDifference {

	 static int maxDifference(int[] a) {
		 int maxDiff;
		    int i, j;
		 
		    int n= a.length;
		    int[]  LMin = new int[n]; 
		    int[] RMax = new int[n];
		 
		    LMin[0] = a[0];
		    for (i = 1; i < n; ++i)
		        LMin[i] = Math.min(a[i], LMin[i-1]);
		 
		    RMax[n-1] = a[n-1];
		    for (j = n-2; j >= 0; --j)
		        RMax[j] = Math.max(a[j], RMax[j+1]);
		 
		    i=0;
		    j=0;
		    maxDiff=-1;
		    int diff=0;
		    while (j < n && i < n)
		    {
		        if (LMin[i] < RMax[j])
		        {
		            maxDiff = Math.max(maxDiff, RMax[j]-LMin[i]);
		            j = j + 1;
		        }
		        else
		            i = i+1;
		    }
		    System.out.println(maxDiff);
		 
		    return maxDiff;
	    }
	 
	 public static void main(String[] args) {
		int[] arr = {2,3,10,2,4,8,1};
		maxDifference(arr);
	}
	
}
