package blog.reversewords;

/**
 * In-place words reversal in a character array
 * @author PRATEEK
 */
public class ReverseWordsCharArray {

	/**Reverse Words in an array
	 */
	private static void reverseWords(char[] str) {
		if(str==null || str.length==0)
			return ;
		
		String temp = new String(str);
		int len = str.length, l=0,r=0;

		//Reverse the input array
		reverseArr(str, 0, str.length-1);
		
		while(r<len && str[r] == ' ') //Skip initial Spaces, if any
			r++;
		
		while(r<len)
		{
			l=r; //l hold the start character of the word
			while(r== len-2 || (r<len-1 && str[r+1] != ' ')) //Get the last character of the word in r
				r++;
						
			reverseArr(str,l,r++);

			while(r<len && str[r] == ' ') //Find the next character using r
				r++;	
		}
		System.out.println(temp +" ----> " +new String(str));
	}
	
	
	/**
	 * Reverse the character array between i and j (inclusive)
	 */
	private static void reverseArr(char[] s,int i, int j) {
		int len=i+(j-i)/2;  //look carefully this line, when i is not 0
		for(;i<=len;i++,j--)
			swap(s,i,j);
	}

	/**
	 * Swaps the ith and jth indices
	 */
	private static void swap(char[] arr,int i, int j) {
		char temp  = arr[i];
		arr[i] = arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		String s1 = "  Coding    Recipes is Super   Cool  ";
		String s2 = "I live to code";
		String s3 = "Recursion is Recursion";
		//reverseWords1(s.toCharArray());
		reverseWords(s1.toCharArray());
		reverseWords(s2.toCharArray());
		reverseWords(s3.toCharArray());
		reverseWords("   ".toCharArray());
		reverseWords(null);
	}
}
