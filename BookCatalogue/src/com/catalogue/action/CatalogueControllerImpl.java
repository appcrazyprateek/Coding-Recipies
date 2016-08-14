package com.catalogue.action;

import java.util.List;

import com.catalogue.dataobject.Book;
import com.catalogue.dataobject.CatalogueNodeType;
import com.catalogue.util.CatalogueTrie;

public class CatalogueControllerImpl extends CatalogueController{

	private CatalogueTrie trie=new CatalogueTrie();
	@Override
	public
	boolean addBook(Book book) {
		trie.put(book.author, book, CatalogueNodeType.AUTHOR);
		trie.put(book.title, book, CatalogueNodeType.TITLE);
		return true;
	}

	@Override
	public
	List<Book> searchBook(String keyword) {
		return trie.get(keyword);
	}

	@Override
	public
	List<Book> searchMostSoldBooks(String keyword, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
