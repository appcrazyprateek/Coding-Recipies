package com.catalogue.dataobject;

public enum Category {
	ACADIMIC(1) , ENTERANCE(2) ;
	
	private int categoryId;

	Category(int id) {
		this.categoryId = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
