package blog.trie.rway;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

	 public char letter;
	 public boolean isWord;
	 public Map<Character,TrieNode> children;
	 
	 public TrieNode(char letter, boolean isWord) {
        this.letter = letter;
        this.isWord = isWord;
        this.children = new HashMap<Character,TrieNode>();
	 }
}