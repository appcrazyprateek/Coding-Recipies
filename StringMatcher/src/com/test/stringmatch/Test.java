package com.test.stringmatch;

public class Test {

	
	public static void main(String[] args) {
		/*TrieTree dict = new TrieTree();        
        dict.addWord("abc", 1);
        dict.addWord("fas", 2);
        dict.addWord("abcd", 3);
        dict.addWord("abed", 4);
       dict.addWord("abcf", 5);
       System.out.println(dict.lookUp("abcd"));
        System.out.println(dict.getMaxLevel("abcd"));
        System.out.println(dict.deleteWord("abcd"));
        System.out.println(dict.lookUp("abcd"));
        //System.out.println(dict.lookUp("fast"));
*/        
		
		//Basic exact match
				/*{
					StringMatcher matcher = new StringMatcher();
					matcher.add_exact_match("contactus", 1);
					//assert(matcher.lookup("contactus") == 1);
					System.out.println(matcher.lookup("contactus"));
				}*/
				//Basic prefix test
				{
					StringMatcher matcher = new StringMatcher();
					matcher.add_prefix_match("img", 1);
					//assert(matcher.lookup("imgcutepuppy") == 1);
					//assert(matcher.lookup("htmlcutepuppy") == -1);
					
					//System.out.println(matcher.lookup("imgcutepuppy") == 1);
					//System.out.println(matcher.lookup("htmlcutepuppy") == -1);
				}
				//Basic longest match test
				{
					StringMatcher matcher = new StringMatcher();
					matcher.add_prefix_match("img", 1);
					matcher.add_prefix_match("imghd", 2);
					//System.out.println(matcher.lookup("imgcutepuppy") == 1);
					//System.out.println(matcher.lookup("imghdcutepuppy") == 2);
				}
				// mix and match
				{
					StringMatcher matcher = new StringMatcher();
					matcher.add_exact_match("abc", 908);
					matcher.add_prefix_match("fas", 907);
					matcher.add_prefix_match("abcd", 901);
					System.out.println(matcher.lookup("abc") == 908); // exact match preferred over prefix match
					System.out.println(matcher.lookup("fast") == 907);
					System.out.println(matcher.delete_exact_match("abc") == true);
					System.out.println(matcher.lookup("abc"));
					System.out.println(matcher.delete_prefix_match("abc") == false);
				}
		
		
		
	}
}
