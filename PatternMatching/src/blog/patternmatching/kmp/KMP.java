package blog.patternmatching.kmp;

/**
 * Knuth- Morris Pratt Algo
 * @author PRATEEK
 */
public class KMP {

	/**
	 * Pattern processing before KMP, prefix function calculates the longest
	 * prefix which is a longest suffix in the pattern
	 */
	private static int[] patternProcessing(String pat) {
		int size = pat.length();
		int[] table = new int[size];

		int i = 1, j = 0;
		while (i < size) {
			if (table[i] == table[j])
				table[i++] = 1 + j++;

			else if (j > 0)
				j = table[j - 1];

			else
				table[i++] = 0;
		}
		return table;
	}

	/**
	 * KMP Sub-routine 
	 * @param text: input text
	 * @param pat input pattern
	 * @return : index at which pattern is found in text
	 */
	public static int kmp(String text, String pat) {
		int patLen = pat.length();
		int textLen = text.length();

		int i = 0, j = 0;
		int[] table = patternProcessing(pat);

		while (i < textLen) 
		{
			if (text.charAt(i) == pat.charAt(j)) 
			{
				if (j == patLen-1)
					return i - j;
				else 
				   {	i++;j++; }

			}
			else if(j>0)
				j = table[j-1];
			else
				i++;
				
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String text = "abcacabacaaaabcccbaa";
		String pat = "acabacaa";
		
		int index= kmp(text,pat);
		System.out.println("found at " + index);
		
	}
}
