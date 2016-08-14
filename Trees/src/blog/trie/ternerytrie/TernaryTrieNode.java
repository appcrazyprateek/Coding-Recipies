package blog.trie.ternerytrie;

public class TernaryTrieNode {

	public char letter;
	public int value=-1;
	public boolean isLeaf = false;
	public TernaryTrieNode left;
	public TernaryTrieNode middle;
	public TernaryTrieNode right;

	public TernaryTrieNode(char letter) {
		this.letter = letter;
	}

    public String toString(){
    	return this.letter + "-->" + this.left + "|" +this.middle + "|" + this.right ; 
    }
}
