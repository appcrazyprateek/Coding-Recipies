package blog.backtrack.knight;

public class KnightTour {

	private static int count=0 ;
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

	
	public static void knightTour(int[][] board, int row , int col , int curr)
	{
		count++;
			if(isValid(board,row,col))
			{
				board[row][col]=curr;
				
				if(curr == (rowLen * colLen - 1))
				{
					printSol(board);
					System.exit(0);
				}
				else
				{
					
					knightTour(board,row + 2 , col + 1, curr+1 );
					knightTour(board,row + 1 , col + 2, curr+1 );
					
					knightTour(board,row - 1 , col + 2, curr+1 );
					knightTour(board,row - 2 , col + 1, curr+1 );
					
					knightTour(board,row - 2 , col - 1, curr+1 );
					knightTour(board,row - 1 , col - 2, curr+1 );
					knightTour(board,row + 1 , col - 2, curr+1 );
					knightTour(board,row + 2 , col - 1, curr+1 );
					
					board[row][col]=BLANK;
				}
			}
	}


	private static boolean isValid(int[][] board, int row, int col) {
		if(row >= 0 && row < colLen && col>=0 && col < rowLen && board[row][col]==BLANK)
			return true;
		return false;
	}


	private static void printSol(int[][] board) {
		for(int i=0;i<colLen;i++)
		{
			for(int j=0;j<rowLen;j++)
			{
				System.out.print(board[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.println("Done" + count);
	}
}
