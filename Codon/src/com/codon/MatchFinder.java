package com.codon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Finds match for a word from input file in the dictionary
 * @author 
 *
 */
public class MatchFinder {

	private static final String DICTIONARY = "D:\\Junk\\genbank.txt";
	private static MatchFinder instance = null;
	private Map<String,Integer> hash = null;
	
	private MatchFinder() {	}
	
	public static MatchFinder getInstance(){
	   	if(instance==null)
	   	{
	   		synchronized (MatchFinder.class) {
	   			if(instance==null)
	   			{
	   				instance = new MatchFinder();
	   				try{
	   					instance.loadDictionary(DICTIONARY);
	   				}
	   				catch(ParseException e)
	   				{
	   					System.err.println("Failed to parse dictionary, check dictionary");
	   				}
	   			}
			}
	   	}
	   	return instance;
	}
	
	public int findMatch(String input)
	{
		if(hash.containsKey(input))
			return hash.get(input);
		return -1;
	}
	
	/** 
	 * Loads the dictionary into memory
	 * @param dictionaryLocation: dictionary Location
	 */
	private void loadDictionary(String dictionaryLocation) throws ParseException{
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(new File(dictionaryLocation)));
			hash = new HashMap<String, Integer>(); //container for holding dictionary words and its page numbers
			String line = "";
			boolean hasContentStarted = false; 
			
			while ((line = br.readLine()) != null) {
				
				if(line.contains("1."))   //finding the starting of the dictionary file
					hasContentStarted = true;

				if(hasContentStarted)
				{
					line = line.trim();
					String[] splits = line.split("[\\s .]+"); //using regular expressions to split by space and dot
					if(splits.length==2)  //check to avoid strings which 
					{
						int value= Integer.parseInt(splits[0]);
						String key= splits[1];
						hash.put(key, value);
					}
				}
				
			}
		}
		
		catch (IOException e) {
			System.err.println("Dictionry Location not found");
		}
		//System.out.println(hash);
	}
}
