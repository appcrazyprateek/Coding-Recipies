package blog.patternmatching.common;

public interface PatternMatching {
	
	int[] preProcess(String pattern);
	int search(String text);
}
