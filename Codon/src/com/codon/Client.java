package com.codon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Client for Invoking the Question provied
 * @author 
 *
 */
public class Client {

	private static final String INPUT= "D:\\Junk\\myequence.txt"; 
	public static void main(String[] args) {
		findMatches(new File(INPUT));
		
	}
	private static void findMatches(File file) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=br.readLine())!=null)
			{
				line = line.trim();
				if(!line.equals(""))
				{
					find(line);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void find(String input){
		MatchFinder matcher = MatchFinder.getInstance();
		int page= matcher.findMatch(input);
		if(page!=-1)
		{
			System.out.println(input + " Page No. " + page);
		}
		else
		{
			System.err.println(input + " : No Match Found");
		}
	}
}
