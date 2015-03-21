package com.test.stringmatch;

import java.util.HashMap;
import java.util.Map;

class TrieTree {        
	 
	private TrieNode root;
	
	 public TrieTree() {
		root = new TrieNode((char) 0);
	}  

	 public boolean deleteWord(String word)
	 {
		 
		 if(lookUp(word)==-1) //word not found
			 return false;
		 
	     int length = word.length();       
	     TrieNode curr = root;   
	     int maxLevel =getMaxLevel(word);
	     for( int index = 0 ; index < length; index++ )
	     {    
	         char ch = word.charAt(index);    
	           
	         Map<Character,TrieNode> child = curr.getChildren();                        
	          
	         if( child.containsKey(ch) )
	         {
	            curr = child.get(ch); 
	         }            
	         if(index == maxLevel)
	         {
	        	 child.remove(ch);
	         }
	     }
		return true;
	 }
	 
	 
	 public int getMaxLevel(String word)
	 {
		 int maxLevel = 1;
		 int length = word.length();       
	     TrieNode curr = root;   
	     for( int index = 0 ; index < length; index++ )
	     {    
	         char ch = word.charAt(index);    
	           
	         Map<Character,TrieNode> child = curr.getChildren();   
	            curr = child.get(ch);
		         if(child.size()!=1)
		        	 maxLevel = index;
	     }
		return maxLevel;
	 }
	 
 public void addWord(String word, int id)  {
        
     int length = word.length();         
     TrieNode curr = root;
        
     //run through the characters of the given word
     for( int index = 0; index < length; index++)
     {
         Map<Character,TrieNode> child = curr.getChildren();            
         char ch = word.charAt(index);
            
         if( child.containsKey(ch))
             curr = child.get(ch);
         else  
         {              
             TrieNode temp = new TrieNode(ch);
             child.put( ch, temp );
             curr = temp;
         }
     }
     curr.setId(id); //set Id to last Character
 }
    
 public int lookUp(String word)  {
	 int lastId=-1;
     int length = word.length();       
        
     TrieNode curr = root;   
       
     for( int index = 0 ; index < length; index++ )
     {    
         char ch = word.charAt(index);    
           
         Map<Character,TrieNode> child = curr.getChildren();                        
          
         if( child.containsKey(ch) )
         {
            curr = child.get(ch); 
            lastId=curr.getId();
         }            
         else  
        	 break;
     }
     return lastId;
 }
}


class TrieNode { 
	private char val;    
    private Map<Character,TrieNode> children;
    private int id=-1;  
	
    
    public TrieNode(char ch)  {
        val = ch;
        children = new HashMap<Character,TrieNode>();
        id = -1;
    }

    @Override
    public String toString() {
    	return val +"-" +children + "-"+id;
    }
    
    public char getVal() {
		return val;
	}
	public void setVal(char val) {
		this.val = val;
	}
	public Map<Character, TrieNode> getChildren() {
		return children;
	}
	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}    
}

