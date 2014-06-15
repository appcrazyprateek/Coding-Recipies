package blog.minwindow;

public class MinWindowWithAllChars {

	public static final int MAX = 256;

	public static void main(String[] args) {
		// String str = "Shopping with flipkart is an awesome experience";
		// String pat = "awesome with flipkart";

		String str = "ABABCDAB";
		String pat = "ABAC";
		minlengthwindow(str.toCharArray(), pat.toCharArray(), 0, 0);
	}

	private static void minlengthwindow(char input[], char chars[], int start,
			int finish) {

		int[] shouldfind = new int[MAX];
		int[] hasfound = new int[MAX];
		int cnt = 0;
		int minwindow = Integer.MAX_VALUE;

		int charlen = chars.length;
		for (int i = 0; i < charlen; i++)
			shouldfind[chars[i]] += 1;

		int iplen = input.length;
		start = 0;
		finish = iplen;
		int j = 0;

		for (int i = 0; i < iplen; i++) {
			if (shouldfind[input[i]] == 0)
				continue;
			hasfound[input[i]] += 1;

			if (shouldfind[input[i]] >= hasfound[input[i]])
				cnt++;

			if (cnt == charlen) {
				while (shouldfind[input[j]] == 0 || hasfound[input[j]] > shouldfind[input[j]])
				{
					if (hasfound[input[j]] > shouldfind[input[j]])
						hasfound[input[j]]--;
					j++;
				}
				if (minwindow > (i - j + 1)) 
				{
					minwindow = i - j + 1;
					finish = i;
					start = j;
				}
			}
		}

	}
}
