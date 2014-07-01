package blog.wordchain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/**
 * Word Chain Problem , Find the number of transitions
 * @author PRATEEK
 */
public class WordChain {

	private static Set<String> dict = new HashSet<String>();

	private static void init() 
	{
		dict.add("rat");
		dict.add("mat");
		dict.add("ray");
		dict.add("may");
		dict.add("bal");
		dict.add("ram");
		dict.add("lay");
	}

	/**
	 * Word Chain Sub-routine, using BFS
	 * @param src: start word
	 * @param dst: end word
	 * @return : number of hops
	 */
	public static int wordChain(String src, String dst)
	{
		int level = 0;

		Queue<String> queue = new LinkedList<String>();
		queue.add(src);
		//used as level separator
		queue.add(null);

		while (!queue.isEmpty()) 
		{
			String popedItem = queue.poll();

			//if null found , then all elements at current level are processed
			if (popedItem == null) 
			{
				queue.offer(null);
				level++;
				continue;
			}

			//Destination word found
			if (popedItem.equalsIgnoreCase(dst))
				return level;

			//Change each character of word from 'a' to 'z', if found in dictionary add to queue, 
			// and remove from dictionary
			int i = 0;
			while (i < popedItem.length()) 
			{
				StringBuilder temp = new StringBuilder(popedItem);
				for (char j = 'a'; j <= 'z'; j++) 
				{
					temp.setCharAt(i, j);

					if (temp.toString().equalsIgnoreCase(dst))
						return level;

					if (dict.contains(temp.toString())) 
					{
						queue.add(temp.toString());
						dict.remove(temp.toString());
					}

				}
				i++;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		init();
		String src = "cat";
		String dst = "bay";
		if (src.length() == dst.length()) {
			int level = wordChain(src, dst);
			System.out.println("No. of Transitions:" + (level+1));
		}
		else
			throw new Exception("Strings of unequal Lengths not permitted");
	}
}
