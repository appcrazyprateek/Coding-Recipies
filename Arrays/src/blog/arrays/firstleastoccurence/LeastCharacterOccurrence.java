/**
 * 
 */
package blog.arrays.firstleastoccurence;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author parul
 *
 */
public class LeastCharacterOccurrence {

	public static void main(String[] args) {
		System.out.println(findLeastOccurrenceCharacter("JavaJuzzler"));
	}
	
	/**
	 * Finds the Minimum Occurence of the character in a string
	 * @param s
	 * @return character with least occurence
	 */
	public static Character findLeastOccurrenceCharacter(String s){
		if(s==null || s.isEmpty())
			return null;
		
		char[] chars = s.toCharArray();
		Map<Character,Integer> hash = new LinkedHashMap<>(chars.length);
		
		for(char c : chars){
			hash.put(c, hash.get(c)== null ? 1 : hash.get(c)+1);
		}
		
		int min = Integer.MAX_VALUE;
		Character minChar = null;
		for(Map.Entry<Character,Integer> entry : hash.entrySet()){
			Character key = entry.getKey();
			Integer value = entry.getValue();
			
			if(value < min){
				min = value;
				minChar = key;
			}
		}
		return minChar;
	}
}
