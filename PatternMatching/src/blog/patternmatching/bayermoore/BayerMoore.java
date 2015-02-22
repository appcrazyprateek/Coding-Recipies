package blog.patternmatching.bayermoore;

import java.util.Arrays;


public class BayerMoore {

	private static final int ALPHABET_SIZE = 256;
	private static final int ASCII_OFFSET = 97;
	
	public static int[] preProcess1(String pat){
		int[] table = new int[ALPHABET_SIZE];
		int len = pat.length(),i=0;
		
		Arrays.fill(table, len );
		
		for(;i<len;i++)
			table[pat.charAt(i)] = len - 1 - i;
		
		return table;
	}
	
	public static int[] preProcess2(String pat){
		return null;
		
		
	}
	
	public static int search(String text , String pattern){

		int patLen = pattern.length();
		int txtLen = text.length();
		
		if(patLen == 0 || txtLen ==0 )
			return -1;
		
		int[] badtable= preProcess1(pattern) ;
		
		int[] gudtable = preProcess2(pattern);
		
		
		
		
		
		
		
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
