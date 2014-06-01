package blog.backtrack.knight;

public class KnightTour {

	private static final int BLANK = -1;
	private static int rowLen;
	private static int colLen;
	
	public static void main(String[] args) {
		
		int[][] board = {
				{-1, -1, -1,-1,   -1, -1,  -1, -1},
				{-1, -1, -1,-1,   -1, -1,  -1, -1},
				{-1, -1, -1,-1,   -1, -1,  -1, -1},
				{-1, -1, -1,-1,   -1, -1,  -1, -1},
				
				{-1, -1, -1,-1,   -1, -1,  -1, -1},
				{-1, -1, -1,-1,   -1, -1,  -1, -1},
				{-1, -1, -1,-1,   -1, -1,  -1, -1},
				{-1, -1, -1,-1,   -1, -1,  -1, -1}
		};
		
		rowLen = board.length;
		colLen = board[0].length;
		knightTour(board, 0, 0, 0);
		
	}

	
	public static boolean knightTour(int[][] board, int row , int col , int curr)
	{
		if(curr == (rowLen * colLen - 1))
		{
			printSol(board);
			return true;
		}
		else 
		{
			if(isValid(board,row,col))
			{
				board[row][col]=curr;
				
				knightTour(board,row - 2 , col - 1, curr++ );
				knightTour(board,row - 2 , col + 1, curr++ );
				knightTour(board,row + 2 , col - 1, curr++ );
				knightTour(board,row + 2 , col + 1, curr++ );
				
				knightTour(board,row - 1 , col - 2, curr++ );
				knightTour(board,row - 1 , col + 2, curr++ );
				knightTour(board,row + 1 , col - 2, curr++ );
				knightTour(board,row + 1 , col + 2, curr++ );
				
				curr --;
				board[row][col]=BLANK;
			}
		}
		return false;
	}


	private static boolean isValid(int[][] board, int row, int col) {
		if(row >= 0 && row < colLen && col>=0 && col < rowLen && board[row][col]==BLANK)
			return true;
		return false;
	}


	private static void printSol(int[][] board) {
		for(int i=0;i<colLen;i++)
		{
			for(int j=0;j<rowLen;i++)
			{
				System.out.print(board[i][j]+ "\t");
			}
			System.out.println();
		}
		
	}
}
