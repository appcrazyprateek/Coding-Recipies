package blog.minwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window in which all the words are found
 * @author PRATEEK
 */
public class MinWindowContainingAllWords {

	private static int minWindow = 9999; // length of minimum window
	private static int startWord = 0; // start position
	private static int endWord = 0; // end position
	/**
	 * Sub-routine to minumum window in which all words of pattern are found in
	 * the given string
	 * @param str : input String
	 * @param pat : pattern
	 */
	public static void minWindow(String str, String pat)
	{

		// words to be found
		Map<String, Integer> toFind = new HashMap<String, Integer>(); 
		// the set	of  words  which are found
		Map<String, Integer> found = new HashMap<String, Integer>(); 

		int foundCount = 0;
		// left pointer of the window, which is moved when all required wrds are
		// found,
		// and is moved until any word from required word is found
		int tempStart = 0;

		// Tokenising Text
		String[] words = str.split(" ");
		int sLen = words.length;

		// Tokenising Pattern
		String[] patTokens = pat.split(" ");
		int pLen = patTokens.length;

		// filling the 'toFind' map
		for (String val : patTokens)
			toFind.put(val, toFind.get(val) == null ? 1 : toFind.get(val) + 1);

		// traversing over text length
		for (int index = 0; index < sLen; index++)
		{
			String word = words[index];

			if (!toFind.containsKey(word))
				continue;

			found.put(word, found.get(word) == null ? 1 : found.get(word) + 1);

			if (toFind.get(word) >= found.get(word))
				foundCount++;

			if (foundCount == pLen) 
			{
				// reduce window size until conditions are violated
				word = words[tempStart];
				while (!toFind.containsKey(word)
						|| toFind.get(word) < found.get(word)) 
				{
					// Discard excess count of the given word
					if (toFind.containsKey(word))
						found.put(word, found.get(word) - 1);

					// get next word, to check if it can be discarded
					word = words[++tempStart];
				}

				// Updating Min Window
				if (minWindow > index - tempStart + 1)
				{
					minWindow = index - tempStart + 1;
					startWord = tempStart;
					endWord = index;
				}
			}
		}
	}

	public static void main(String[] args) {

		String str = "Shopping with xyz.com is an awesome experience";
		String pat = "awesome with xyz.com";
		minWindow(str, pat);
		//System.out.println("Start :" + startWord + "   End : " + endWord);

		System.out.println("Window Containing all words");
		// Tokenising Text
		String[] words = str.split(" ");
		for(int i=startWord;i<=endWord;i++)
			System.err.print(words[i]+"  ");

	}
}
