package com.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Decoding {

	public static void main(String[] args) {
		String thisLine=null;
		List<Integer> list = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 try {
				/*while ((thisLine = br.readLine()) != null) {
					list.add(Integer.parseInt(thisLine));
				 }*/
			 String numbers = br.readLine();
			 String[] numberslited = numbers.split(" ");
			 for(String s : numberslited)
			 {
				 try{
					 list.add(Integer.parseInt(s));
				 }
				 catch(Exception e)
				 {
					 
				 }
				 
			 }
			 
			} catch (IOException e) {
				System.out.println("Expection in readign");
				e.printStackTrace();
			}
		
		//int[] numbers = {25626 , 25757 , 24367 , 24267 , 16 , 100  , 2 , 7277};
		solve(list.toArray(new Integer[list.size()]));
	}
	
	public static void solve(Integer[] numbers)
	{
		int curr = numbers[0];
		int next = 0;
		System.out.print(curr+" ");
		for(int i=1;i<numbers.length;i++)
		{
			next = numbers[i];
			int diff = next - curr;
			if(!doesLieInRange(diff))
			{
				System.out.print(-128 + " ");
			}
			System.out.print(diff+ " ");
			
			curr = next;
		}
	}
	
	public static boolean doesLieInRange(int diff)
	{
		if(diff <=127 && diff >= -127)
			return true;
		return false;
					
	}
	
}
