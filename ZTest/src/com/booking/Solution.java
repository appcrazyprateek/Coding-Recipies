package com.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) {
	String thisLine=null;
	Set<String> set = new TreeSet<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 try {
			while ((thisLine = br.readLine()) != null) {
				//thisLine=thisLine.replaceAll("\\s","");
				set.add(thisLine);
			 }
		} catch (IOException e) {
			System.out.println("Expection in readign");
			e.printStackTrace();
		}
		
		 Solution sol = new Solution();
		 sol.decorateSolution(set);
	}
	
	
	
	
	public void decorateSolution(Set<String> strings)
	{
		List<String> clone = new ArrayList<String>(strings.size());
		clone.addAll(strings);
		
		StringBuilder result = new StringBuilder("");
		
		for(int i=0;i<clone.size();i++)
		{
			String current = clone.get(i);
			result.append(current);
			for(int j=i+1;j<clone.size();j++)
			{
				String anotherString = clone.get(j);
				
				if(checkAnagram(current,anotherString))
				{
					result.append(",");
					result.append(anotherString);
					clone.remove(anotherString);
					j--;
				}
			}
			result.append("\n");
		}
		
		System.out.println(result.toString());
	}
	
	public static boolean checkAnagram(String first, String second) {
		first = first.replaceAll("\\s","");
		second = second.replaceAll("\\s","");
		
		char[] characters = first.toCharArray();
		StringBuilder sbSecond = new StringBuilder(second);
		for (char ch : characters) {
			int index = sbSecond.indexOf("" + ch);
			if (index != -1) {
				sbSecond.deleteCharAt(index);
			} else {
				return false;
			}
		}
		return sbSecond.length() == 0 ? true : false;
	}

}
