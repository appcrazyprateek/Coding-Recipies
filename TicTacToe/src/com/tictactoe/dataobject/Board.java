package com.tictactoe.dataobject;

public class Board {
	public Cell[][] cells =null ;
	public final int ROWS,COLS ;
	public int currRow , currCol ;
	public String player1;
	public String player2;
	
	public Board(int rows, int cols) throws Throwable {
		if(rows!=cols || rows<2 || cols < 2)
			throw new Throwable("Invalid Row and Column Size, row:"+rows + " ,col:"+cols);
		
		ROWS = rows;  COLS = cols;
		cells = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
	}
	
	public void init() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            cells[row][col].clear();  // clear the cell content
	         }
	      }
	   }
	
	
	public boolean isDraw()
	{
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if(cells[i][j].content == Seed.EMPTY)
					return false;
			}
		}
		return true;
	}
	
	public boolean hasWon(Seed seed)
	{
		return rowWin(seed) || colWin(seed) || diagonalWin(seed);
	}
	
	private boolean diagonalWin(Seed seed) {
		int count =0;
		if(currRow == currCol)
		{
			for(int i=0;i<ROWS;i++)
			{
				if(cells[i][i].content == seed)
					count++;
			}
		}
		else if(currRow + currCol == ROWS - 1)
		{
			for(int i=0;i<ROWS;i++)
			{
				if(cells[i][ROWS -1 - i].content== seed)
					count++;
			}
		}
		
		if(count == ROWS)
			return true;
			
		return false;
	}

	private boolean colWin(Seed seed) {
		int count = 0;
		for(int i=0;i<ROWS;i++)
		{
			if(cells[i][currCol].content == seed)
				count++;
		}
		if(count == ROWS)
			return true;
		return false;
	}

	private boolean rowWin(Seed seed) {
		int count = 0;
		for(int i=0;i<ROWS;i++)
		{
			if(cells[currRow][i].content == seed)
				count++;
		}
		if(count == ROWS)
			return true;
		return false;
	}

	public void paint(){
		for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            cells[row][col].paint();
	         }
	         System.out.println();
	         if (row < ROWS - 1) {
	            System.out.println("-----------");
	         }
	      }
	}
}
