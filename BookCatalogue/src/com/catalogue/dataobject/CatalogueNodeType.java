package com.catalogue.dataobject;

public enum CatalogueNodeType {
	AUTHOR(1) , TITLE(2) , CATEGORY(3);
	
	private int nodeType;

	CatalogueNodeType(int id) {
		this.setNodeType(id);
	}

	public int getNodeType() {
		return nodeType;
	}

	public void setNodeType(int nodeType) {
		this.nodeType = nodeType;
	}
}
