package blog.trie.ternerytrie;

/**
 * Ternary Trie Implementation
 * @author Prateek Rathore
 */
public class TernaryTrie {

	//Root of the Trie
	private TernaryTrieNode root;

	/**
	 *public Insert procedure of Trie
	 */
	public void put(String key, int val){
		root = put(root,key,val, 0);
	}

	/**
	 * @return updated root of the trie
	 */
	private TernaryTrieNode put(TernaryTrieNode node,String key, int val, int index){
		char letter = key.charAt(index); 

		if(node==null) // Node does not exist, create
			node=new TernaryTrieNode(letter);

		if(node.letter < letter) 
			node.right = put(node.right,key,val,index);

		else if(node.letter > letter)
			node.left=put(node.left,key,val,index);

		else if(index == (key.length()-1))
			node.middle= put(node.left,key,val,index+1);

		else
			node.value= val;

		return node;
	}

	/**
	 * Finds if Key exists
	 */
	public boolean contains(String key){
		return get(root,key,0) != null ;
	}

	/**
	 * Get value for given key
	 */
	public int get(String key){
		return get(root,key,0).value;
	}

	/**
	 * Private GET implementation
	 * @return , last node character of key
	 */
	private TernaryTrieNode get(TernaryTrieNode node,String key, int index){
		if(node==null)
			return null;

		char letter=key.charAt(index);

		if(node.letter > letter)
			return get(node.left,key,index);

		else if(node.letter < letter)
			return get(node.right, key, index);

		else if(index == (key.length()-1))
			return get(node.middle, key, index+1);

		else
			return node;
	}
	
	public void remove(String key){
		remove(root, null, key, 0);
	}
	
	private TernaryTrieNode remove(TernaryTrieNode root, TernaryTrieNode parent , String key , int index){
		if(root.left==null)
			return null;
	
		TernaryTrieNode foundNode=get(root, key, 0);
		
		if(foundNode==null){
			System.out.println("Key not Found");
			return null;
		}
		
		TernaryTrieNode foundNodeParent=getParent(root,foundNode,key);
		
		while(true){
			if(foundNode.left !=null && foundNode.right!=null)
			{
				break;
			}
			else if(foundNode.left ==null && foundNode.right!=null)
			{
				break;
			}
			else if(foundNode.left !=null && foundNode.right==null)
			{
				break;
			}
			else
			{
				break;
			}
		}
		return null;
	}
	
	public TernaryTrieNode getParent(TernaryTrieNode root, TernaryTrieNode node, String key){
		return node;
	}
}
