package com.employee;

class Node {
	public char value;
	public char character;
	public Node left ;
	public Node right;
	
	public Node() {}
	
	public Node(char value)
	{
		this.value = value;
	}
	
	public Node(char value,char character ) {
		this.value=value;
		this.character=character;
	}
	
	@Override
	public String toString() {
		return "Value : " + value + " Character  : " + character;
	}
}


public  class Entity  {

	public static final char CHAR_SPECIAL= '|';
	private static Node root = null;
	
	public static void main(String[] args) {
		
		Entity  entity = new Entity();
		//entity.addNode('A', "01");
		entity.addNode('B', "1000");
		//entity.addNode('C', "101");
		entity.addNode('D', "100");
		
		//System.out.println(entity.getWord("01|100|101"));
	}
	
	
	public void addNode(char c , String code )
	{
		if(root==null)
		root = new Node();
		
		int len = code.length() ;
		int i= 0;
		Node temp = root;
		char currentChar = 0 ;
		Node parent = root;
		while(i<len)
		{
			currentChar = code.charAt(i); 
			if(currentChar == '1')
				temp = temp.left;
			else
				temp = temp.right;
			
			if(temp ==null && i!=len-1)
			{
				
				temp = new Node(currentChar);
			}
			else
			{
				temp = new Node(currentChar,c);
			}
			i++;
		}
	}
	
	
	public String getWord(String binaryString){
		int len = binaryString.length();
		String result = "";
		String code = "";
		for (int i=0;i<len-1;i++)
		{
			char currentChar = binaryString.charAt(i);
			if(currentChar!=CHAR_SPECIAL){
				code = code + currentChar;
				continue;
			}
			else{
				result = result + getCharacter(root,code);
				code = "";
			}
		}
		return result;
	}



	private char getCharacter(Node root, String code) {
		int len = code.length();
		int i=0;
		Node temp = root;
		while(i!=len){
			if(code.charAt(i) == '1')
			{
				temp=temp.left;
			}
			else
			{
				temp = temp.right;
			}
			i++;
		}
		return temp.character ;
	}
	
	
	
	
	
	
	
}
