package com.catalogue.util;
import java.util.List;

import com.catalogue.dataobject.Book;
import com.catalogue.dataobject.CatalogueNode;
import com.catalogue.dataobject.CatalogueNodeType;
/**
 * Catalogue Trie maintaining Books on the basis of Nodetype , 
 * refer CatalogueNodeType
 * @author prathore2
 *
 */
public class CatalogueTrie {

	//Root of the Trie
	private CatalogueNode root;
	
	public void put(String key,Book book, CatalogueNodeType nodeType ){
		root = put(key,book, nodeType , root , 0);
	}

	private CatalogueNode put(String key, Book book,
			CatalogueNodeType nodeType, CatalogueNode node, int index) {
		
		char letter = key.charAt(index); 
		
		if(node==null) // Node does not exist, create
			node=new CatalogueNode(letter);
		
		if(node.letter < letter)
		{
			node.right = put(key,book,nodeType,node.right,index);
		}
		else if(node.letter > letter)
		{
			node.left = put(key,book,nodeType,node.left,index);
		}
		else if(index == (key.length()-1))
		{
			node.isLeaf=true;
			node.books.add(book);
			node.nodeType = nodeType;
		}
		else
		{
			node.middle = put(key,book,nodeType,node.middle,index+1);
		}
		return node;
	}
	
	public boolean contains(String key){
		return get(root,key,0) != null ;
	}

	
	public List<Book> get(String key){
		return get(root,key,0).books;
	}

	/**
	 * Private GET implementation
	 * @return , last node character of key
	 */
	private CatalogueNode get(CatalogueNode node,String key, int index){
		if(node==null)
			return null;

		char letter=key.charAt(index);

		if(node.letter > letter)
			return get(node.left,key,index);

		else if(node.letter < letter)
			return get(node.right, key, index);

		else if(index == (key.length()-1))
			return node;

		else
			return get(node.middle, key, index+1);
	}
}
