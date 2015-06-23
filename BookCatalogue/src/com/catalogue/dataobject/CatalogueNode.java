package com.catalogue.dataobject;

import java.util.ArrayList;
import java.util.List;


public class CatalogueNode {
	public char letter;
	public boolean isLeaf=false;
	public List<Book> books = new ArrayList<Book>(1);
	public CatalogueNodeType nodeType;
	public CatalogueNode left;
	public CatalogueNode middle;
	public CatalogueNode right;

	public CatalogueNode(char letter) {
		this.letter = letter;
	}

    public String toString(){
    	return this.letter + "-->" + this.left + "|" +this.middle + "|" + this.right ; 
    }
}
