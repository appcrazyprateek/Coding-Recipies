package com.classloader;

public class PositiveNegative {

	public static void main(String args[]){
	//int ar[]={1,-3,8,4,-2,-6,7};
		
	//int ar[]={1,-3,8,4,-2,-6,7,-7,-9};
		
		int ar[]={1,-3,8,4,-2,-6,7,-7,-9,3,-7,3,-6,-8,-10,-11};
		
		int tempx=0;
		int tempy=0;
		//int i=0;
		//int j=i+1;
		
		for(int i=0,j=i+1;j<ar.length-1;){
			while(i<=ar.length-1 && ar[i]>0 ) 
			{
				i=i+2;
				
			}	
				
			if(i<=ar.length-1)
				{tempx=ar[i];}
		
			
			while(j<ar.length-1 && ar[j]<0 )
			{
				j=j+2;
			
			}
				if(j<=ar.length-1)
				{tempy=ar[j];}
				
				if(i<=ar.length-1 && j<ar.length)		
				{	ar[j]=tempx;
		            ar[i]=tempy;
		            tempx=0;
		            tempy=0;
		        }
			
			
		}
		for(int z=0;z<ar.length;z++)
		System.out.print("" +ar[z] + " ");
	}
}