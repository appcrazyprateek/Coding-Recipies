package com.pubmatic.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns the indeces where pattern is matched
 * @author PRATEEK
 *
 */
public class FindPatternOccurences {

	static List<Integer> indices= new ArrayList();
	
	public static void main(String[] args) {
		String str= "asnmnshtadfgmnstksjdkjhasdjkaasdsadgadfgmnstsdjadaklsjdlka";
		String pat="adfgmnst";
		
		System.out.println(findOccurences(str,pat));
	}
	

	public static int[] prekmp(String pattern) {
		int[] next = new int[pattern.length()];
		int i = 0, j = -1;
		next[0] = -1;
		while (i < pattern.length() - 1) 
		{
			while (j >= 0 && pattern.charAt(i) != pattern.charAt(j))
				j = next[j];
			i++;
			j++;
			next[i] = j;
		}
		return next;
	}


	public static List<Integer> findOccurences(String text, String pattern) {

		int[] next = prekmp(pattern);
		int i = 0, j = 0;
		while (i < text.length())
		{
			while (j >= 0 && j<=pattern.length()-1 && text.charAt(i) != pattern.charAt(j))
				j = next[j];

			i++;
			j++;
			if (j == pattern.length())
			{
				indices.add(i- pattern.length());
				j=0;
			}
				
		}
		if(indices.size()==0)
			return null;
		
		return indices;
	}

}
