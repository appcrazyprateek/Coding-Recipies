package com.catalogue.dataobject;

import java.util.Date;

public class Book {
	public String title;
	public String author;
	public String publisher;
	public Date publisherYear;
	public Category category;
	public SubCategory subCategory;
	public int price;
	public int soldCount;
	
	public Book(String title,String author){
		this.title=title;
		this.author=author;
		this.price=0;
		this.soldCount=0;
	}
	
	public Book(String title,String author,String publisher,
			Date publisherYear,Category category,SubCategory subCategory,
			int price , int soldCount ) {
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.publisherYear=publisherYear;
		this.category=category;
		this.subCategory=subCategory;
		this.price=price;
		this.soldCount=soldCount;
	}
	
	@Override
	public String toString() {
		return "{ Title : "+title + " Author : "+ author + " }\n";
	}
}
