package com.codon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/**
 * Find the Frequency of Codon and Print the combinations of CODONS for the given Word
 * @author 
 */
public class CountCodon {
	private static int count;

	private static String file = "C:\\input.txt";
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(new File(file)));
		String[] words = br.readLine().trim().split(" ");
		
		Map<Character,String[]> hash=init();
		for(String word : words)
		{
			count=0;
			word=word.trim().toUpperCase();
			combinations(hash, word , word.length(),0 ,"");
			System.out.println("Total Combinations :"+count);
			Collection<String[]> codons = hash.values();
			
			Iterator it = codons.iterator();
			
			while(it.hasNext())
			{
				String[] codes = (String[]) it.next();
				for(String code : codes )
				{
					int freq = getFrequencyCount(code, word,hash);
					System.out.println("CODON : "+code + " ---> " + "FREQ : " +freq);
				}
				
			}
			
			
			
		}
/*		String word1 = "PELPEVETTR";
		String codon1 = "CCC";
		solve(word1,codon1);*/

		/*String word2 = "PELPEVETTR";
		String codon2 = "CAG";
		count=0;
		solve(word2,codon2);*/
		
		/*String word3 = "PELPEVEVVTPTTR";
		String codon3 = "CCA";
		count=0;
		solve(word3,codon3);*/
	}
	
	
/*	private static void solve(String word, String codon) {
		Map<Character,String[]> hash=init();
		
		combinations(hash, word , word.length(),0 ,"");
		System.out.println("Total Combinations :"+count);
		
		int freq = getFrequencyCount(codon, word,hash);
		System.out.println("CODON : "+codon + " ---> " + "FREQ : " +freq);
		System.out.println("######################################");
	}*/


	/**
	 * Returns the frequency count of the CODON
	 * @param codon
	 * @param word
	 * @param hash
	 * @return
	 */
	private static int getFrequencyCount(String codon ,String word, Map<Character, String[]> hash) {
		
		int currCount = 1;

		int len=word.length();
		//count the total combinations
		for(int i=0;i<len;i++)
		{
			if(hash.get(word.charAt(i)) != null)
			currCount = currCount * hash.get(word.charAt(i)).length ;
		}
			
		//System.out.println("Total Combinations :"+currCount);
		
		//Iterate over map and fetch, the character and size of the codons corresponding to that character
		char c = 0;
		int size=0;
		for(Entry<Character, String[]> entry : hash.entrySet())
		{
			String[] vals =entry.getValue();
			for(String v:vals)
			{
				if(v.equalsIgnoreCase(codon)) //if codon is found, get the character
				{
					c=entry.getKey();
					size=vals.length;
					break;
				}
			}
		}
		
		//If no charater is found corresponding to the CODON
		if(c==0)
			return 0;
		
		//No. of times the character appears in the word, tricky 
		int charCount = word.split(c+"").length-1;
		
		return charCount * (currCount/size);
	}

	/**
	 * Prints All combinations of the codons
	 * @param hash: storage unit of character and corresponding codons
	 * @param word: the given word , eg: 
	 * @param len: length or 'word'
	 * @param i: currrent character in 'word'
	 * @param s: combination formed in intermediate steps
	 */
	private static void combinations(Map<Character, String[]> hash,
			String word, int len , int i,String s) {
		
		//if currCharacter reaches end of word, print
		if(i>=len)
		{
			System.out.println(s);
			count++;
			return;
		}
		 
		//current Character
		char c = word.charAt(i);
		//Codons corresponding to the character
		String[] codons = hash.get(c);
		
		String temp = s;
		if(codons!=null)
		{
			for(int j=0;j<codons.length;j++)
			{
				s=temp; //initialize s , with the value held in temp everytime s gets modified
				s = s+":"+codons[j];
				combinations(hash,word,len,i+1,s);
			}
		}
		else
		{
			combinations(hash,word,len,i+1,s);
		}
	}
	
	/**
	 * Initialzing Map
	 * @return: returns map of character and its corresponding Codons
	 */
	private static Map<Character,String[]> init() {
		Map<Character,String[]> hash = new HashMap<Character,String[]>();
		hash.put('P',new String[]{"CCV","CCC","CCA"});
		hash.put('E',new String[]{"CAA","CAG"});
		hash.put('L',new String[]{"UUA","UUG"});
		hash.put('V',new String[]{"GUU","GUC"});
		hash.put('T',new String[]{"UAU","UAC"});
		hash.put('R',new String[]{"CGU","CGC"});
		return hash;
	}
	
}
