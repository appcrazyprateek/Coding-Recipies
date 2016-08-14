package com.catalogue.action;

import java.util.List;

import com.catalogue.dataobject.Book;

public abstract class CatalogueController {
	public abstract boolean addBook(Book book);
	public abstract List<Book> searchBook(String keyword);
	public abstract List<Book> searchMostSoldBooks(String keyword, int limit);
}
