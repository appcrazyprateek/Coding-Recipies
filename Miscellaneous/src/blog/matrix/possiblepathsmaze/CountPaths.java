package blog.matrix.possiblepathsmaze;

/**
 * Find count of possible paths in the maze
 * @author PRATEEK
 */
public class CountPaths {

	private static int rowLen, colLen, count;
	public static void paths(int[][] maze, int row, int col) {
		if (row == rowLen && col == colLen) {
			count++;
			return;
		}
		/*// move left
		if (col > 0 && maze[row][col - 1] == 1)
			paths(maze, row, col - 1);*/

		// move right
		if (col < colLen && maze[row][col + 1] == 1)
			paths(maze, row, col + 1);

		/*// move up
		if (row > 0 && maze[row - 1][col] == 1)
			paths(maze, row - 1, col);*/

		// move down
		if (row < rowLen && maze[row + 1][col] == 1)
			paths(maze, row + 1, col);

	}

	public static void main(String[] args) {
		int[][] maze = { 
				{1, 1, 0, 0, 1, 1 }, 
				{1, 1, 1, 1, 0, 0 },
				{1, 0, 0, 0, 1, 0 }, 
				{1, 1, 1, 1, 0, 0 },
				{1, 0, 1, 0, 0, 0 },
				{1, 1, 1, 1, 1, 1 }
		};
		
		rowLen = maze.length-1;
		colLen = maze[0].length-1;
		
		paths(maze,0,0);
		System.out.println("Number of Paths: "+count);
	}
}
