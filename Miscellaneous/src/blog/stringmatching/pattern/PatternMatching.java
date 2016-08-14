package blog.stringmatching.pattern;

// Naive Method
public class PatternMatching {

	static String  txt="AABAACAADAABAAABAA";
	static String pat="AABA";
	
	public static void main(String[] args) {
		check();
		
	}

	private static void check() {
		
		int txtlen=txt.length();
		int patlen=pat.length();
		
		for(int i=0;i<txtlen-patlen;i++)
		{
			for(int j=0; j<patlen ;j++)
			{
				if(txt.charAt(i+j)!=pat.charAt(j))
				{
					break;
				}
				if(j==patlen-1)
				{
					System.out.println("Match Found at "+i);
				}
			}
		}
		
	}
}
