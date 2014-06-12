package blog.dp.wordbreak;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class WordBreak {

	private static Set<String> dict;
	
	public static void main(String[] args) {
		
		dict = new HashSet<String>();
		dict.add("i");
		dict.add("love");
		dict.add("loves");
		dict.add("samsung");
		
		String str = "ilovessamsung";
		
		wBreak(str,0,str.length(),new LinkedHashSet<String>());
	}
	
	public static void wBreak(String str,int start, int size, Set<String> hash)
	{
		if(start==size)
		{
			printSolution(hash);
			return ;
		}
		
		String temp="";
		for(int i=start;i<size;i++)
		{
			temp = temp + str.charAt(i)+"";
			if(dict.contains(temp))
			{
				hash.add(temp);
				wBreak(str, i+1, size, hash);
				hash.remove(temp);
			}
		}
	}
	
	
	
	
	/*public static void wordBreak(String str,Set<String> dict)
	{
		int size= str.length();
		if(size == 0 )
			return ;
		
		boolean[] sol = new boolean[size +1 ];
		
		for(int i=0;i<size;i++)
		{
			if(sol[i]==false && dict.contains(str.substring(0, i)))
				sol[i]=true;
			
			if(sol[i]==true)
			{
				if(i==size)
					return;
			}
			
		}
		
	}*/
	
	
	private static void printSolution(Set<String> hash) {
		for(String word : hash)
			System.out.print(word + "\t");
	}

}
