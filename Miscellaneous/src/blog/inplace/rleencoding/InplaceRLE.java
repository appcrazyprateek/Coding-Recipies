package blog.inplace.rleencoding;

/**
 * Perform Runtime lenth Encoding
 * @author PRATEEK
 */
public class InplaceRLE {
	
	public static void main(String[] args) {
		String s1="aaabbcccdee";
		rleEncoding(s1);
		String s2="abcde";
		rleEncoding(s2);
		String s3="abbbcccddde";
		rleEncoding(s3);
	}

	private static void rleEncoding(String s1) {
		
		StringBuilder s = new StringBuilder(s1);
		int len = s.length(),count = 1;
		int holder=0; //used for updating the characters

		char currChar = s.charAt(0);
		for(int i=1;i<len;i++) 
		{
			if(s.charAt(i-1) == s.charAt(i))
				count++;
			else
			{
				s.setCharAt(holder++, currChar);
				if(count>1)
					s.setCharAt(holder++,(char)('0'+count));
				
				currChar = s.charAt(i);
				count = 1;
			}
		}
		//Update Last character stats
		s.setCharAt(holder++, currChar);
		if(count>1)
			s.setCharAt(holder++,(char)('0'+count));
		
		//mark rest of string
		while(holder<len)
			s.setCharAt(holder++,'_');
		
		System.out.println(s1 + " ---->  "+s);
	}
}
