package blog.matrix.islands;

/**
 * Count the number of Islands
 * @author PRATEEK
 *
 */
public class CountIslands {

	static int[][] solution;
	public static void solve(int[][] arr,int[][] sol)
	{
		int row=arr.length;
		int col=arr[0].length;
		
		for(int j=0;j<col;j++)
		{
			for(int i=0;i<row;i++)
			{
				if(arr[row][col]==1 &&  sol[row][col] !=1 )
				{
					
				}
			}
		}
					
	}
	
	public static void backTrack(int row,int col, int[][] arr,int[][] sol)
	{
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		int[][] maze = { 
				{1, 1, 0, 0, 1, 1 }, 
				{1, 0, 1, 1, 0, 0 },
				{1, 0, 0, 0, 1, 0 }, 
				{1, 1, 1, 2, 0, 0 },
				{1, 0, 0, 0, 0, 0 },
				{1, 1, 1, 1, 1, 1 }
		};

		int[][] solution= new int[maze.length][maze[0].length];
		
	}
}
