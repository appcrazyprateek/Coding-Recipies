package blog.backtrack.Nqueen;
/**
 * N Queen Problem Using backtracing(backtracing is achieved by overriting.
 * @author Prateek
 */
public  class NQueen {

	int[][] chess;
	int size;  // matrix is sqaure
	int[] sol; // contains value of columns

	public NQueen(int[][] matrix){

		this.chess=matrix;
		this.size = matrix.length;

		this.sol=new int[matrix.length];
	}

	/**
	 * Check if Queen can be placed for a given row,col
	 * @return true if queen can be placed
	 */
	private boolean isValidPlacement(int[][] chess, int givenRow , int givenCol) {

		for(int currentRow=0;currentRow < givenRow ; currentRow ++)
		{
			//  column check
			if (sol[currentRow]==givenCol)
				return false;

			//diagonal check condition
			if(Math.abs(sol[currentRow ] - givenCol) == Math.abs(currentRow - givenRow))
				return false;
		}
		return true;
	}

	/**
	 * Iterates over the a given row , for all columns
	 * @param chess : input chess board
	 * @param givenRow 
	 * @param size : length or breadth of matrix for a N x N matrix
	 */
	private void solveNQueen(int chess[][] , int givenRow , int size) {

		for(int currentCol=0;currentCol < size ; currentCol ++)
		{
			if(isValidPlacement(chess, givenRow ,  currentCol) == true)
			{
				sol[givenRow] = currentCol ;

 				if(givenRow == size - 1) // this was the last row , print soln
					printSolution(sol);

				else  // proceed with next row
				{
					int nextRow=givenRow + 1 ;
					solveNQueen(chess, nextRow, size) ;
				}
			}
		}
	}

	/*private void printSolution(int[]sol) {
		int len=sol.length;
		System.out.println("-------------------------");
		for(int i=0 ; i  < len ;i++ )
		{
			System.out.println(i +"  " + sol[i]);
		}
		System.out.println("-------------------------");
	}*/

	private void printSolution(int[]sol) {
		System.out.println("-------------------------");
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++) {
				if(sol[i] == j)
					System.out.print("1");
				else
					System.out.print("0");
				System.out.print("\t");
			}
				
			System.out.println();
		}
		System.out.println("-------------------------");
	}



	public static void main(String[] args) {
		int chess[][] = { {0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
		};

		NQueen obj=new NQueen(chess) ;
		obj.solveNQueen( chess,  0, chess.length) ;
	}
}
