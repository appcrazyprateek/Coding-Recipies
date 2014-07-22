/**
 * 
 */
package blog.validateBrackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given an sequence of brackets , confirm if sequence is valid
 * @author PRATEEK
 */
public class ValidateBrackets {
	
	private static Map<Character,Character> hash = new HashMap<>();
	
	static {
		hash.put('{','}');
		hash.put('[',']');
		hash.put('(',')');
	}
	
	/**
	 * Sub-routine to validate the sequence of brackets
	 * @param s
	 * @return
	 */
	public static boolean validate(String s){
		char[] arr = s.toCharArray();
		
		Stack<Character> stack = new Stack<>();
		for(Character c:arr)
		{
			  switch (c) {
			case '[':
			case '{':
			case '(':
			{
				stack.push(c);
				break;
			}	
			case ']':
			case '}':
			case ')':
			{
				if(hash.values().contains(c))
				{
					if(!stack.isEmpty() && hash.get(stack.peek())==c)
						stack.pop();
					else if(stack.isEmpty())
						return false;
				}
				break;
			  }
			default:
				break;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s= "{()}[]";
		boolean isValid = validate(s);
		System.out.println("input: "+s);
		System.out.println("output: " +isValid);
	}
}
