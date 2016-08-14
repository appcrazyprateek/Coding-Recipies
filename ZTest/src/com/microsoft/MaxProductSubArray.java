package com.microsoft;

public class MaxProductSubArray {

	static int maximum_product_subarray(int[] a) {
	int len = a.length;
		int res = a[0];
	        int maxp = a[0];
	        int minp = a[0];
	        for (int i=1;i<len;i++){
	            int tmpmax = maxp;
	            int tmpmin = minp;
	            maxp = Math.max(Math.max(tmpmax*a[i],tmpmin*a[i]),a[i]);
	            minp = Math.min(Math.min(tmpmax*a[i],tmpmin*a[i]),a[i]);
	            res = Math.max(maxp,res);
	        }
	        return res;
    }
	
	public static void main(String[] args) {
		
	}
}
