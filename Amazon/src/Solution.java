/**
 * Given a string, construct a new string by rearranging the original string and deleting characters as needed. Return the alphabetically largest string that can be constructed respecting a limit as to how many consecutive characters can be the same.

Example:
s='bacc'
k=2

The largest string, alphabetically, is 'cccba' but it is not allowed because it uses the character 'c' more than 2 times consecutively. Therefore, the answer is 'ccbca'.
 * @author Prateek Rathore
 *
 */
public class Solution {

	public static String getLargestString(String s, int k) {

		int[] countArray = new int[26];
		char[] chars = s.toCharArray();
		for (char c : chars) 
			countArray[c - 'a'] += 1;

		String result = "";

		int i = 25;
		while (i >= 0) {
		    //chars more than k
			if (countArray[i] >= k) {
				
				//Add K Characters
				int count = k;
				while (count > 0) {
					result = result.concat(getLetter(i));
					count--;
				}
				countArray[i] -= k;

				//Iterate until you find a character
				int j = i - 1;
				while (countArray[j] <= 0 && j > 0)
					j -= 1;

				//Just add 1 chracter
				if (countArray[j] > 0 && j >= 0) {
					result = result.concat(getLetter(j));
					countArray[j] -= 1;
				}

				else {
					break;
				}
				//chars less than k , simple append
			} else if (countArray[i] > 0){
				int count = countArray[i];
				while(count > 0) {
					result = result.concat(getLetter(i));
					count--;
				}
				countArray[i] = 0;
				//No char here on this index
			} else { 
				i -=1;
			}
		}
		//System.out.println(result);
		return result;
	}
	
	private static String getLetter(int i) {
		return (char)(i + 'a') + "";
	}

	public static void main(String[] args) {
		getLargestString("bacc", 2); //output : ccbca
		getLargestString("zzzazzb", 2); //output : zzazz
		getLargestString("zzzxazz", 2); //output : zzxzza
		getLargestString("zzzzzzxxxzzaabbazza", 5); //output : zzzzzxzzzzzxxbbaaaa
		
	}
}