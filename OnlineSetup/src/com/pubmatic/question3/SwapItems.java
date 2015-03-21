package com.pubmatic.question3;

/**
 * bring all intergers to front and characters to the end 
 * @author PRATEEK
 */
		
public class SwapItems {
	
	public static void main(String[] args) {
		String str= "ASDSA123APB1234";
		System.out.println(swapItems(str));
	}
	
	public static String swapItems( String str)
	{
		char[] input=str.toCharArray();
		int i=0,j=input.length-1;
		
		while(i<j)
		{
			while(Character.isDigit(input[i]) && i<j)
				i++;
			
			while(Character.isLetter(input[j]) && i<j)
				j--;
			
			swap(input,i++,j--);
		}
		return String.valueOf(input);
	}
	
	/** 
	 * swap elements at the defined indices
	 */
	public static void swap(char[] input,int i,int j)
	{
		char temp=input[i];
		input[i]=input[j];
		input[j]=temp;
	}
}
