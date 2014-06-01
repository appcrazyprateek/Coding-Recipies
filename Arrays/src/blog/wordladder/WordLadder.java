/**
 * 
 */
package blog.wordladder;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author PRATEEK
 * 
 */
public class WordLadder {
	
	public static void main(String[] args) {
		String start= "hit";
		String end= "cog";
		Set<String> dict= new LinkedHashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		int result=wordLength(start,end,dict);
		System.out.println(result);
		
	}
	

	public static int wordLength(String start, String end, Set<String> dictionary) {
		if (dictionary.size() == 0)
			return 0;

		int result = 0;

		Queue<String> wordQ = new LinkedList<>();
		Queue<Integer> distQ = new LinkedList<>();

		wordQ.add(start);
		distQ.add(1);

		while (!wordQ.isEmpty()) {
			String currWord = wordQ.poll();
			Integer currDist = distQ.poll();

			if (currWord.equalsIgnoreCase(end))
				return currDist;

			for (int i = 0; i < currWord.length(); i++)
			{
				char[] chars = currWord.toCharArray();

				for (char c = 'a'; c <= 'z'; c++) 
				{
					chars[i] = c;

					String s = new String(chars);
					if (dictionary.contains(s))
					{
						System.out.println(s);
						wordQ.add(s);
						distQ.add(currDist + 1);
						result=currDist + 1;
						dictionary.remove(s);
					}
				}
			}
		}

		return 0;
	}
}
