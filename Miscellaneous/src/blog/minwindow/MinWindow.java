package blog.minwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window in which all the words are found
 * @author PRATEEK
 */
public class MinWindow {

	
	private static int minWindow = 9999;   //length of minimum window
	private static int startWord = 0;    //start position 
	private static int endWord = 0;      //end position

	public static void main(String[] args) {

		String str = "Shopping with flipkart is an awesome experience";
		String pat = "awesome with flipkart";
		minWindow(str, pat);
		System.out.println("Start :" + startWord + "   End : " + endWord);

	}

	/**
	 * Sub-routine to minumum window in which all words of pattern are found in the given string
	 * @param str : input String 
	 * @param pat : pattern 
	 */
	public static void minWindow(String str, String pat) { 
		
		Map<String, Integer> toFind = new HashMap<String, Integer>(); //words to be found
		Map<String, Integer> found;   // the set of words which are found
		int foundCount = 0;
		int tempStart = 0;
		
		String[] words = str.split(" ");
		int sLen = words.length;
		
		String[] temp = pat.split(" ");
		int pLen = temp.length;

		for (String val : temp)
			toFind.put(val, toFind.get(val) == null ? 1 : toFind.get(val) + 1);

		found = new HashMap<String, Integer>(toFind.size());

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
				//reduce window size until conditions are violated
				word=words[tempStart];
				while (!toFind.containsKey(word) || toFind.get(word) < found.get(word)) 
				{
					if (toFind.containsKey(word))
						found.put(word, found.get(word) - 1);

					word=words[++tempStart];
				}
				
				//Updating Min Window
				if (minWindow > index - tempStart + 1) {
					minWindow = index - tempStart + 1;
					startWord = tempStart;
					endWord = index;
				}
			}
		}
	}
}
