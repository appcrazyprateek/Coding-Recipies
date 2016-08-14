package blog.backtrack.maze;

/**
 * Topic : Backtracking
 *  Rat Maze Problem
 * @author Prateek
 */

public class SolveMaze {

	int rowLen;  // Lenth 
	int colLen;
	int [][] maze;
	boolean isSolvale;
	//constructor 
	public SolveMaze(int maze[][] ){
		this.rowLen =maze.length -1   ;
		this.colLen=maze[0].length -1 ;
		this.maze=maze;
	}

	/**
	 * Check Validity of start point
	 * @return true if points are valid
	 */
	private boolean isValidInput(int startRow , int startCol){
		if(startRow > rowLen || startCol > colLen || startRow < 0 || startCol < 0){
			return false;}
		return true;
	}

	public void solve(int startRow, int startCol){

	
		if(isValidInput(startRow, startCol))
		{
			//  solution matrix, initialisation
			int[][] solution = new int[maze.length][maze[0].length]; 

			solveMaze(maze,solution,startRow, startCol ) ;
			
			//System.out.println(isSolvale);
			if(!isSolvale)
				System.out.println("Path does not exist");
		}
		else
			System.out.println("Invalid Start Point");
	}

	/**
	 * Recursive subroutine for the path
	 * @param maze : input maze
	 * @param solution : solution of maze
	 * @param row : current row
	 * @param col : current col
	 */
	private void solveMaze(int maze[][] , int solution[][] , int row, int col) {

		//exit gate reached
		if(row == rowLen && col == colLen){
			solution[row][col]=1;
			printSolution(solution);
			this.isSolvale=true;
		}

		// Move Down
		if(row  < rowLen )
		{
			if(maze[row+1][col] == 1) {
				solution[row][col]=1;
				solveMaze(maze , solution , row + 1 , col);
				solution[row][col]=0;
			}
		}

		//Move Right
		if(col  < colLen )
		{
			if(maze[row][col+1] == 1) {
				solution[row][col]=1;
				solveMaze(maze , solution , row , col +1 );
				solution[row][col]=0;
			}
		}
		
	}


	private void printSolution(int[][] solution) {
		int rLen=solution.length;
		int cLen=solution[0].length;

		for(int i=0 ; i  < rLen ;i++ )
		{
			for (int j=0 ; j< cLen ;j++)
			{
				System.out.print(solution[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int [][] maze =  { {1, 1, 0, 1 , 1 },
						   {0, 1, 0, 1 , 0 },
						   {0, 1, 1, 1 , 0 },
						   {0, 1, 0, 1 , 0 },
						   {1, 0, 1, 1 , 1 }
						};

		SolveMaze obj=new SolveMaze(maze) ;
		obj.solve(0, 0);
	}
}
