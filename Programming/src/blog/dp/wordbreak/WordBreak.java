package blog.dp.wordbreak;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * @author PRATEEK
 */
public class WordBreak {
	private static Set<String> dict;
	
	public static void main(String[] args) {
		
		dict = new HashSet<String>();
		/*dict.add("i");
		dict.add("love");
		dict.add("loves");
		dict.add("samsung");*/
		dict.add("code");
		dict.add("to");
		dict.add("death");
		
		//String str = "ilovessamsung";
		String str = "codetodeath";
		
		wBreak(str,0,str.length(),new LinkedHashSet<String>());
	}
	
	public static void wBreak(String str,int start, int size, Set<String> hash)
	{
		if(start==size)
		{
			System.out.println(hash.toString());
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
}
