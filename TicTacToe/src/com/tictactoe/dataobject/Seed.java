package com.tictactoe.dataobject;

public enum Seed {
	EMPTY("-") , CROSS("X") , NOUGHT("O") ;
	String content;
	Seed(String c)
	{
		content = c;
	}
	
	public String getContent() {
		return content;
	}
}
