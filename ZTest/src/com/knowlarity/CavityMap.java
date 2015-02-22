package com.knowlarity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CavityMap {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++)
            {
               String line = br.readLine();
               for(int j=0;j<line.length();j++)
               {
            	   map[i][j]= Integer.parseInt(line.charAt(j)+"");
               }
        }
        
      //  int[][] map = { {1,1,1,2} , {1,9,1,2} , {1,8,9,2} , {1,2,3,4}};
        cavity(map);
	}
	
	
	 static void cavity(int[][] map){
		int n=map.length;
		int row=0;int col=0;
		for(;row<n;row++)  
		   {  
			col=0;
		     for(;col<n;col++)  
		     {  
		    	int item = map[row][col];
		       if(row == 0 || col == 0 || row == n-1 || col == n-1 )  
		       {  
		         System.out.print(item);  
		       }  
		       else if(map[row - 1][col - 1] <= item && 
		   			map[row - 1][col] <= item	&&
					map[row - 1][col + 1] <= item &&
					map[row][col - 1] <= item &&
					map[row][col + 1] <= item && 
					map[row + 1][col - 1] <= item && 
					map[row + 1][col] <= item && 
					map[row + 1][col + 1] <= item)  
		       {  
		    	   System.out.print("X") ;    
		       }  
		       else  
		       {  
		    	   System.out.print(item);  
		       }  
		     }  
		    System.out.println();
		   }  
	}
	
	/*static String cavity(int[][] map)
	{
		int n = map.length;
		int[][] temp= new int[n][n];
		
		for(int row=1;row<n-1;row++)
		{
			for(int col=1;col<n-1;col++)
			{
				if(isDepth(map, row, col))
				{
					temp[row][col]=-1;
				}
			}
		}
		return null;
	}
	
	static boolean isDepth(int[][] map, int row, int col) {
		boolean flag = true;
		int curr = map[row][col];
		if (map[row - 1][col - 1] < curr && 
			map[row - 1][col] < curr	&&
			map[row - 1][col + 1] < curr &&
			map[row][col - 1] < curr &&
			map[row][col + 1] < curr && 
			map[row + 1][col - 1] < curr && 
			map[row + 1][col] < curr && 
			map[row + 1][col + 1] < curr)
			return true;
		return false;
	}
	*/
	
}
