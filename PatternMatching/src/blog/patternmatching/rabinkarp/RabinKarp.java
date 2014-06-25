package blog.patternmatching.rabinkarp;

/**
 * Rabin Karp uses hashing technique to search for Strings TODO: Design better
 * hash function
 * @author PRATEEK
 * 
 */
public class RabinKarp {

	private static final int CONSTANT_PRIME = 101;
	private long pathash;
	private int radix;
	private String pat;
	private int patLen;
	private long RM1;

	public RabinKarp( String pat) {
		radix = 256;
		patLen = pat.length();
		this.pat = pat;

		RM1 = 1;
		for (int i = 1; i < patLen; i++)
			RM1 = (radix * RM1) % CONSTANT_PRIME;

		pathash = hash(pat, patLen);
	}

	private long hash(String pat, int len) {
		long h = 0;
		for (int j = 0; j < len; j++)
			h = (radix * h + pat.charAt(j)) % CONSTANT_PRIME;
		return h;
	}

	private boolean doesMatch(String text, int currIndex) {
		for (int j = 0; j < patLen; j++)
			if (pat.charAt(j) != text.charAt(currIndex + 1 + j))
				return false;
		return true;
	}

	public int search(String text) {
		int textLen = text.length();
		if (patLen > textLen)
			return -1;

		long textHash = hash(text, patLen);

		for (int i = 0; i < textLen - patLen; i++) {
			textHash = radix * (textHash - RM1 * text.charAt(i))% CONSTANT_PRIME   +   CONSTANT_PRIME + text.charAt(i + patLen) % CONSTANT_PRIME;
			if (textHash == pathash && doesMatch(text, i))
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {

		String pat = "prateek";
		String txt = "Welcome prateek to Goldman";
		
		RabinKarp rabin = new RabinKarp( pat);
		int index= rabin.search(txt);
		System.out.println("Text found at "+ index + ": " + txt.substring(index, index+ pat.length()+1));
	}
}
