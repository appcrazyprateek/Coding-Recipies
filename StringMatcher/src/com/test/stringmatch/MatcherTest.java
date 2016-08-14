/*package com.test.stringmatch;

public class MatcherTest {
	public static void main(String[] args)
	{
		//Basic exact match
		{
			StringMatcher matcher = new StringMatcher();
			matcher.add_exact_match("contactus", 1);
			assert(matcher.lookup("contactus") == 1);
		}
		//Basic prefix test
		{
			StringMatcher matcher = new StringMatcher();
			matcher.add_prefix_match("img", 1);
			assert(matcher.lookup("imgcutepuppy") == 1);
			assert(matcher.lookup("htmlcutepuppy") == -1);
		}
		//Basic longest match test
		{
			StringMatcher matcher = new StringMatcher();
			matcher.add_prefix_match("img", 1);
			matcher.add_prefix_match("imghd", 2);
			assert(matcher.lookup("imgcutepuppy") == 1);
			assert(matcher.lookup("imghdcutepuppy") == 2);
		}
		// mix and match
		{
			StringMatcher matcher = new StringMatcher();
			matcher.add_exact_match("abc", 908);
			matcher.add_prefix_match("fas", 907);
			matcher.add_prefix_match("abcd", 901);
			assert(matcher.lookup("abc") == 908); // exact match preferred over prefix match
			assert(matcher.lookup("fast") == 907);
			assert(matcher.delete_exact_match("abc") == true);
			assert(matcher.lookup("abc") == 901);
			assert(matcher.delete_prefix_match("abc") == false);
		}
	}
}
*/