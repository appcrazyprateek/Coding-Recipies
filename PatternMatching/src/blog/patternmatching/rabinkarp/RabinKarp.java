package blog.patternmatching.rabinkarp;

/**
 * Rabin Karp uses hashing technique to search for Strings 
 * @author PRATEEK Rathore
 */
public class RabinKarp {
 
	//Contant prime number
	private static final int CONSTANT_PRIME = 101;
	//Hash Value of the pattern which will remain constant through out the problem
	private long pathash;
	private int radix;
	//Input pattern
	private String pat;
	//Pattern Length
	private int patLen;
	
	//Its the place value of Most Significant bit
	private long RM1;

	//Preprocessing of pattern in the constructor
	public RabinKarp( String pat) {
		radix = 256;
		patLen = pat.length();
		this.pat = pat;

		RM1 = 1;
		for (int i = 1; i < patLen; i++)
			RM1 = (radix * RM1) % CONSTANT_PRIME;

		//return hash value of pattern
		pathash = hash(pat, patLen);
	}

	//Return hash value of given string from 0 to the input length
	private long hash(String pat, int len) {
		long h = 0;
		for (int j = 0; j < len; j++)
			h = (radix * h + pat.charAt(j)) % CONSTANT_PRIME;
		return h;
	}

	/**
	 * Sub-routine called when hash-function is equal,
	 * character by character comparison is done.
	 */
	private boolean doesMatch(String text, int currIndex) {
		for (int j = 0; j < patLen; j++)
			if (pat.charAt(j) != text.charAt(currIndex + 1 + j))
				return false;
		return true;
	}

	/**
	 * Search for the pattern in the input string
	 * @param text
	 * @return: index where pattern is found in text
	 */
	public int search(String text) {
		int textLen = text.length();
		if (patLen > textLen)
			return -1;

		long textHash = hash(text, patLen);

		for (int i = 0; i < textLen - patLen; i++) {
			textHash = radix * (textHash - RM1 * text.charAt(i))% CONSTANT_PRIME 
							+ CONSTANT_PRIME 
							+ text.charAt(i + patLen) % CONSTANT_PRIME;
			if (textHash == pathash && doesMatch(text, i))
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {

		String pat = "prateek";
		String txt = "Welcome prateek to Bangalore";
		
		RabinKarp rabin = new RabinKarp( pat);
		int index= rabin.search(txt);
		System.out.println("Text found at "+ index + ": " + txt.substring(index, index+ pat.length()+1));
	}
}
