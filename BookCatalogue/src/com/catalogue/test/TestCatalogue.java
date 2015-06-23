package com.catalogue.test;

import java.util.List;

import com.catalogue.action.CatalogueController;
import com.catalogue.action.CatalogueControllerImpl;
import com.catalogue.dataobject.Book;

public class TestCatalogue {

	public static void main(String[] args) {
		CatalogueController controller = new CatalogueControllerImpl();
		controller.addBook(new Book("Java","Kathy"));
		controller.addBook(new Book("Algorithms","Cormen"));
		controller.addBook(new Book("Algorithms","Karumanchi"));
		controller.addBook(new Book("C","Shaum"));
		controller.addBook(new Book("C","Kanetkar"));
		
		controller.addBook(new Book("Java","headfirst"));
		controller.addBook(new Book("Design","headfirst"));
		controller.addBook(new Book("Design","Shaum"));
		
		List<Book> books = controller.searchBook("Java");
		books = controller.searchBook("headfirst");
		System.out.println(books);
	}
}
