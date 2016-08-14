package com.flipkart.beans;

import java.util.List;

public class Board {

	private static int[][] board;
	
	private static int size = 10;
	
	private static Board instance;
	
	private List<int[]> magicCoordinates;
	
	public static Board getInstance(){
		if(instance==null)
			instance = new Board();
		
		return instance;
	}
	
	public static void createBoard(int N) throws Exception
	{
		if(board==null)
		{
			board = new int[N][N];
			size= N;
		}
	}
	
	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Board.size = size;
	}

	public List<int[]> getMagicCoordinates() {
		return magicCoordinates;
	}

	public void setMagicCoordinates(List<int[]> magicCoordinates) {
		this.magicCoordinates = magicCoordinates;
	}

}
