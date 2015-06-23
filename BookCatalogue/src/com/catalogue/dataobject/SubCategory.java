package com.catalogue.dataobject;

public enum SubCategory {
	ACADIMIC(1) , ENTERANCE(2) ;
	
	private int subCategoryId;

	SubCategory(int id) {
		this.setSubCategoryId(id);
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

}
