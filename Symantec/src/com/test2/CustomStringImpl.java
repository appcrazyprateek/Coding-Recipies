package com.test2;

interface CustomString{
	//char[] thisString=null;
	
	int length();
	CustomString subString(int begin);
	//CustomString subString(int begin, int end);
	/*CustomString areEqual(CustomString s1 , CustomString s2);
	CustomString concat(CustomString anotherString);
	CustomString[] split(String splitter);
	
	CustomString replace(Character currChar , Character anotherChar);
	CustomString replaceAll(Character currChar , Character anotherChar);*/
	
	
}

public final class CustomStringImpl implements CustomString {

	private char[] thisString=null;
	
	public CustomStringImpl(char[] string) {
		this.thisString=string;
	}
	
	
	//Hello;
	
	@Override
	public int length() {
		int i=0;
		for(;i<thisString.length;i++)
		{
			char ch = thisString[i];
			if(ch != ' ')
				return i+1;
		}
		return i+1;
	}
	
	
	@Override
	public CustomString subString(int begin) {
		if(begin < thisString.length)
		{
			CustomString antherString = null;
			char[] anotherArr = new char[thisString.length - begin];
			for(int i=begin ;i<thisString.length;i++)
			{
				anotherArr[i-begin] = thisString[i];
			}
			antherString = new CustomStringImpl(anotherArr);
			return antherString;
		}
		else 
			return null;
	}
	
	
	public static void main(String[] args) {
		
	}
}
