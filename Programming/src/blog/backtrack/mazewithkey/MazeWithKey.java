package blog.backtrack.mazewithkey;
/**
 * Find the way through the maze, also find the key
 * @author Prateek
 */
public class MazeWithKey {
	static int N;
	static int size;
	static boolean isKeyFound=false;
	static int[][] solution;

	private static boolean solveMaze(int maze[][] , int solution[][] , int row , int col){

		// exit gate reached
		if (row == size && col == size) {
			if(isKeyFound){
				solution[row][col] = 1;
				System.out.println("Path Marix is :");
				printSolution(solution);
				System.out.println("===============================");
				return true;
			}
		}

		// Move Down
		if (row < size)
		{
			if (maze[row + 1][col] == 1 || maze[row + 1][col] == 2) 
			{
				if(solution[row + 1][col] != 1){ //to avoid re-selecting the same cell

					if(maze[row + 1][col] == 2){
						isKeyFound=true;
					}

					solution[row][col] = 1;
					solveMaze(maze, solution, row + 1, col);
					solution[row][col] = 0;

					if(maze[row + 1][col] == 2){
						isKeyFound=false;
					}
				}
			}
		}

		// Move Right
		if (col < size)
		{
			if (maze[row][col + 1] == 1 || maze[row][col + 1] == 2)
			{
				if(solution[row][col + 1] != 1){

					if(maze[row][col + 1] == 2){
						isKeyFound=true;
					}

					solution[row][col] = 1;
					solveMaze(maze, solution, row, col + 1);
					solution[row][col] = 0;

					if(maze[row][col + 1] == 2){
						isKeyFound=false;
					}
				}
			}
		}

		// Move Up
		if (row > 0)
		{
			if (maze[row - 1][col] == 1 || maze[row - 1][col] == 2) 
			{
				if(solution[row - 1][col] != 1){

					if(maze[row - 1][col] == 2){
						isKeyFound=true;
					}

					solution[row][col] = 1;
					solveMaze(maze, solution, row - 1, col);
					solution[row][col] = 0;

					if(maze[row - 1][col] == 2){
						isKeyFound=false;
					}
				}
			}
		}

		// Move Left
		if (col > 0)
		{
			if (maze[row][col -1] == 1 || maze[row][col -1] == 2)
			{

				if(solution[row][col -1] != 1){


					if(maze[row][col -1] == 2){
						isKeyFound=true;
					}

					solution[row][col] = 1;
					solveMaze(maze, solution, row, col -1);
					solution[row][col] = 0;

					if(maze[row][col -1] == 2){
						isKeyFound=false;
					}
				}
			}
		}

		//Move NW
		if (row > 0 && col > 0 )
		{
			if (maze[row - 1][col - 1] == 1 || maze[row - 1][col - 1] == 2) 
			{
				if(solution[row - 1][col - 1] != 1){

					if(maze[row - 1][col - 1] == 2){
						isKeyFound=true;
					}

					solution[row][col] = 1;
					solveMaze(maze, solution, row - 1, col - 1);
					solution[row][col] = 0;

					if(maze[row - 1][col - 1] == 2){
						isKeyFound=false;
					}
				}
			}
		}

		//Move NE
		if (row > 0 && col < size )
		{
			if (maze[row - 1][col + 1] == 1 || maze[row - 1][col + 1] == 2) 
			{
				if(solution[row - 1][col + 1] != 1){

					if(maze[row - 1][col + 1] == 2){
						isKeyFound=true;
					}

					solution[row][col] = 1;
					solveMaze(maze, solution, row - 1, col + 1);
					solution[row][col] = 0;

					if(maze[row - 1][col + 1] == 2){
						isKeyFound=false;
					}
				}
			}
		}


		//Move SE
		if (row < size && col < size )
		{
			if (maze[row + 1][col + 1] == 1 || maze[row + 1][col + 1] == 2) 
			{
				if(solution[row + 1][col + 1] != 1){
					if(maze[row + 1][col + 1] == 2){
						isKeyFound=true;
					}

					solution[row][col] = 1;
					solveMaze(maze, solution, row + 1, col + 1);
					solution[row][col] = 0;

					if(maze[row + 1][col + 1] == 2){
						isKeyFound=false;
					}
				}
			}
		}

		//Move SW
		if (row < size && col > 0 )
		{
			if (maze[row + 1][col - 1] == 1 || maze[row + 1][col - 1] == 2) 
			{
				if(solution[row + 1][col - 1] != 1){
					if( maze[row + 1][col - 1] == 2){
						isKeyFound=true;
					}

					solution[row][col] = 1;
					solveMaze(maze, solution, row + 1, col - 1);
					solution[row][col] = 0;

					if( maze[row + 1][col - 1] == 2){
						isKeyFound=false;
					}
				}
			}
		}
		
		return false;
	}

	private static void printSolution(int[][] solution) {
		int rLen = solution.length;
		int cLen = solution[0].length;

		for (int i = 0; i < rLen; i++)
		{
			for (int j = 0; j < cLen; j++)
			{
				System.out.print(solution[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		MazeWithKey mazeObj=new MazeWithKey();
		mazeObj.init();
	}
	
	
	private void init(){
		int[][] maze = { 
				{1, 1, 0, 0, 1, 1 }, 
				{1, 0, 1, 1, 0, 0 },
				{1, 0, 0, 0, 1, 0 }, 
				{1, 1, 1, 2, 0, 0 },
				{1, 0, 0, 0, 0, 0 },
				{1, 1, 1, 1, 1, 1 }
		};

		
		size = maze.length - 1;

		int[][] solution= new int[maze.length][maze[0].length];
		
		System.out.println("Input Matrix is ");
		printSolution(maze);
		
		System.out.println("===========================");
		solveMaze(maze,solution, 0 ,0 );
	}
}
