package blog.misc;

import java.io.*;
import java.util.Scanner;

public class SearchCharater
{
	public static void main(String args[])
	{
		String inputString,str;
		int current,count=0;
		char key;

		Scanner keyboard=new Scanner(System.in);

		System.out.println("Enter first String: ");
		inputString=keyboard.nextLine();

		System.out.println("Enter character :");
		str=keyboard.nextLine();
		key=str.charAt(0);

		current=inputString.indexOf(key,0);
		while(current!=-1)
		{
			count++;
			current=inputString.indexOf(key,current+1);
		}

		System.out.println("Number of"+key+"S: "+count);

		System.exit(0);
	}
}