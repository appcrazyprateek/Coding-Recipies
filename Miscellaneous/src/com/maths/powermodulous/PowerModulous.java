package com.maths.powermodulous;

public class PowerModulous {

	public static void main(String[] args) {
		System.out.println(	pow(71045970,41535484,64735492));
	}
	
	 static int pow(int base, int n, int div) {
         if (n == 0) 
        	 return 1 % div;

         //after multiplication the result will spill integer range
       long result = 1,b = base;
    
         while (n > 0) {
             if (n % 2 == 1) {
            	 n--;
                 result *= b;
                 result %=div;
             } else {
            	 n /= 2;
                 b *= b;
                 b %=div;
             }
         }
         if (result < 0) 
        	 result = (result + div) % div;
         return (int) result;
     }
}
