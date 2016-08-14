package com.tictactoe.dataobject;

public class Cell {

	public  Seed content;
	public int row , col ;
	
	public Cell(int row,int col) {
		this.row=row;
		this.col = col;
	}
	public void clear() {
		content = Seed.EMPTY;
	}
	
	public void paint() {
		System.out.print(content.getContent() + "    ");
	}
	
	@Override
	public String toString() {
		return content.getContent();
	}
}
