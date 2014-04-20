/**
 * 
 */
package blog.missingchar;

/**
 * Given Input String and range find the missing character 
 * @author Prateek
 */
public class MissingChar {

	private static final int offset = 97;
	private static final int PRESENT = 1;
	private static final int BLANK = 32;

	public static char missingChar(String input, char startChar, char endChar) {
		if (input == null || input.equals(""))
			return (char) BLANK;

		int start = (int) startChar, end = (int) endChar;

		int[] hash = new int[end - start+1];
        input=input.toLowerCase();
        
        int i=0;
        for(;i<input.length();i++){
        	int item =(int)input.charAt(i);
        	hash[item - offset]=PRESENT;
        }
        i=0;
        for(;i<hash.length;i++){
        	if(hash[i]!=PRESENT)
        		return (char)(i+offset);
        }
		return (char)BLANK;
	}
	
	public static void main(String[] args) {
		String s="bcADf";
		
		System.out.println(missingChar(s, 'a', 'f'));
		
	}
}