package com.hackerrank;

public class Solution {


	
	public static int[] getFactors(int number){
        int i,j=0;int[] fact=new int[100000];
        for (i=2;i<number;i++){
                 if(number%i==0) {
                 fact[j]=i;
                 j++;
                 }
        }
        return fact;
    }
    
    
    public static int getMinSplit( int width , int height, int nTiles){
    
        long w=width;
        long h=height;
        int n=nTiles;
        int i,j,l,fact1,fact2;
        int min=10; 
         
         
        if( w*h < n ) return -1;
        if(w*h == n) return 0;
        
        int[] fact=getFactors(n);
        
        i=l=0;
        
        while(fact[i]>0){
         i++;
        }
        l=i;
         
        
        for (i=0,j=l ; i <=j ; i++,j--){
        
            fact1=fact[i];
            fact2=fact[j];
             
            if ( fact1 == w && fact2 < h ) {min = 1;}
            else if ( fact2 == h && fact1 < w )  {min = 1;}            
             
            else if(w<Math.max(fact1, fact2) && h<Math.max(fact1, fact2))                    
                min=-1;                    
                    
            else
                min = Math.min (min, 2);
        }
        return min;
    }




	public static void main(String[] args) {
		
		int val1=getMinSplit(5,4,12);
		int val2=getMinSplit(12,10,120);
		int val3=getMinSplit(2,2,1);
		int val4=getMinSplit(17,19,111);
		int val5=getMinSplit(226800000,10000000,938071715);
		
		System.out.println(val1  + "  " + val2 +  "   "  + val3  + "  " + val4 +  "   "  + val5 );
		
	}
	
}
