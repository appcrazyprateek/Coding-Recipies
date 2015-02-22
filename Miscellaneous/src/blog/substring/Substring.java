package blog.substring;

public class Substring {

	public static void main(String[] args) {
		String str = "prateek";
		String pat = "tee";

		String s = isSubString(str, pat);
		System.out.println(s);
	}

	private static String isSubString(String str, String pat) {

		if (str == null || pat == null)
			return null;

		int sLen = str.length(), pLen = pat.length(), k = 0, j = 0;

		if (sLen == 0 || pLen == 0)
			return null;

		for (int i = 0; i < sLen; i++) {
			if (sLen - i + 1 < pLen)
				return null;

			k = i;
			j = 0;
			String temp = "";
			while (j < pLen && k < sLen && str.charAt(k) == pat.charAt(j)) {
				temp = temp + str.charAt(i + j);
				k++;
				j++;
				if (j == pLen)
					return temp;
			}
		}
		return null;
	}
}
