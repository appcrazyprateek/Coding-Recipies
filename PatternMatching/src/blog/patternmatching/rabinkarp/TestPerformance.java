package blog.patternmatching.rabinkarp;

import java.util.Arrays;

public class TestPerformance {

	public static void main(String[] args) {
		int[] temp = makeOffsetTable("qcabdabdab".toCharArray());
		System.out.println(Arrays.toString(temp));
	}

	 /** Makes the jump table based on the scan offset which mismatch occurs. **/
    private static int[] makeOffsetTable(char[] pattern) 
    {
      int[] table = new int[pattern.length];
      int lastPrefixPosition = pattern.length;
      for (int i = pattern.length - 1; i >= 0; --i) 
      {
          if (isPrefix(pattern, i + 1)) 
                 lastPrefixPosition = i + 1;
            table[pattern.length - 1 - i] = lastPrefixPosition - i + pattern.length - 1;
      }
      for (int i = 0; i < pattern.length - 1; ++i) 
      {
            int slen = suffixLength(pattern, i);
            table[slen] = pattern.length - 1 - i + slen;
      }
      return table;
  }
  /** function to check if needle[p:end] a prefix of pattern **/
  private static boolean isPrefix(char[] pattern, int p) 
  {
      for (int i = p, j = 0; i < pattern.length; ++i, ++j) 
          if (pattern[i] != pattern[j]) 
                return false;
      return true;
  }
  /** function to returns the maximum length of the substring ends at p and is a suffix **/
  private static int suffixLength(char[] pattern, int p) 
  {
      int len = 0;
      for (int i = p, j = pattern.length - 1; i >= 0 && pattern[i] == pattern[j]; --i, --j) 
             len += 1;
      return len;
  }
	
}
