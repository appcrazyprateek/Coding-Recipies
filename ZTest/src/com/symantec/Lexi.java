package com.symantec;

import java.util.Stack;


public class Lexi {

	static int minRotate(String A) {
		
		String min = A;
		int minIndex = 0;
		
		String prev = A;
		String curr= A;
		for(int i=0;i<A.length();i++)
		{
			//curr= rotateOnce(prev);
			if(curr.compareTo(min) < 0)
			{
				min = curr;
				minIndex=i+1;
			}
				
			prev= curr;
		}
		return minIndex;
	}
	
	public static void main(String[] args) {
		System.out.println(rotateOnce("abc"));
	}

	 static String rotateOnce(String s)
		{
		 
		 StringBuilder sb = new StringBuilder(s);
		 char c = sb.charAt(0);
		 sb = sb.deleteCharAt(0).append(c);
			return sb.toString();
			
		}
	
	  static String braces(String value) {
		  Stack<Character> stack = new Stack<Character>();
		  for(int i=0;i<value.length();i++)
		  {
			  Character item = value.charAt(i);
			  switch(item)
			  {
				  case '[':
				  case '{':
				  case '(':
					  stack.push(item);
					  break;
				  case '}' :
					  if(!stack.isEmpty() && stack.peek()== '{')
					  {
						  stack.pop();
						  break;
					  }
				  case ']' :
					  if(!stack.isEmpty() && stack.peek()== '[')
					  {
						  stack.pop();
						  break;
					  }
				  case ')' :
					  if(!stack.isEmpty() && stack.peek()== '(')
					  {
						  stack.pop();
						  break;
					  }
					  default : 
						  return "NO";
			  }
		  }
		  return stack.isEmpty()  ? "YES" : "NO";
	    }

	/* public static void main(String[] args) {
		System.out.println(minRotate("baabccd"));
	}*/
	 
	/*
	
	static int minRotate(String A) {
		
		char[] input = A.toCharArray();
 		
		Map<Character,Integer> hash= new HashMap<>();
		int j=1;
		for(char i='a' ; i<='z';i++,j++)
		{
			hash.put(i, j);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<A.length();i++)
		{
			rotateOnce(input);
			
		}
		
		return 0;
	}
	
	
	
	public static void rotateOnce(char []input){
		char temp = input[0];
		int i=1;
		for(;i<input.length;i++)
		{
			input[i-1]=input[i];
		}
		input[i]=temp;
	}*/
}
