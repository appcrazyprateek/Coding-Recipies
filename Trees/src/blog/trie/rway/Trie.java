package blog.trie.rway;

class TrieNode {
	public static final int DEFAULT_SIZE = 26;
	public boolean isWord = false;
	public TrieNode[] children = new TrieNode[DEFAULT_SIZE];
}

public class Trie {
	
	public TrieNode root = null;
	
	public void insert(String key, String val) {
		
	}
	
	public String search(String key) {
		return key;
		
	}
	
	public static void main(String[] args) {

	}
}
