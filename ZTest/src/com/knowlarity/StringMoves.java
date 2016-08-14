package com.knowlarity;

import java.util.HashSet;

public class StringMoves {

	static int easyStrings(String a, String b) {
		char[] in = a.toCharArray();
		int len = in.length;
		int i=0;
		for(;i<len;i++)
		{
			a=swap(in, i, i+1);
			if(a.equals(b))
				break;
			a=swap(in, i, i+1);
		}
		System.out.println(i);
		return i < len -i ? i : len - i; 
	}

	
	
	private static String swap(char[] in, int i, int j) {
		if(j>=in.length)
			j=0;
		
		char temp = in[i];
		in[i] = in[j];
		in[j]=temp;
		
		return new String(in);
	}



	public static void main(String[] args) {
		easyStrings("hello", "lloeh");
	}
}
