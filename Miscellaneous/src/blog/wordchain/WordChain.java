package blog.wordchain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Word Chain Problem , Find the number of transitions
 * 
 * @author PRATEEK
 */
public class WordChain {

	private static final int LOWCHAR = 97;
	private static final int HIGHCHAR = 123;

	private static Set<String> dict = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		init();
		String src = "cat";
		String dst = "bay";
		if (src.length() == dst.length()) {
			int level = wordChain(src, dst);
			System.out.println("No. of Transitions:" + level);
		}

		else
			throw new Exception("Strings on unequal Lengths not permitted");

	}

	private static void init() {
		dict.add("rat");
		dict.add("mat");
		dict.add("ray");
		dict.add("may");
		dict.add("bal");
	}

	public static int wordChain(String src, String dst) {
		int level = 0;

		Queue<String> queue = new LinkedList<String>();
		queue.add(src);
		queue.add(null);

		while (!queue.isEmpty()) {
			String popedItem = queue.poll();

			if (popedItem == null) {
				queue.offer(null);
				level++;
				continue;
			}

			if (popedItem.equalsIgnoreCase(dst))
				return level;

			int i = 0;
			while (i < popedItem.length()) {
				StringBuilder temp = new StringBuilder(popedItem);
				for (char j = 'a'; j <= 'z'; j++) {
					temp.setCharAt(i,j);

					if (temp.toString().equalsIgnoreCase(dst))
						return level;

					if (dict.contains(temp.toString())) {
						queue.add(temp.toString());
						dict.remove(temp.toString());
					}

				}
				i++;
			}
		}
		return -1;
	}

	private static List<String> getWords(String word) {

		List<String> wordList = new ArrayList<String>();
		int i = 0;
		while (i < word.length()) {
			StringBuilder temp = new StringBuilder(word);
			for (int j = 97; j <= 123; j++) {
				temp.setCharAt(i, (char) j);
				if (dict.contains(temp.toString())) {
					wordList.add(temp.toString());
					dict.remove(temp.toString());
				}

			}
			i++;
		}
		return wordList;
	}

}
