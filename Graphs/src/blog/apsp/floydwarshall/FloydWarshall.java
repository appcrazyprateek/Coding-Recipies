package blog.apsp.floydwarshall;

/**
 * Floyd Warshall Implementation
 * @author Prateek Rathore
 */
public class FloydWarshall {

	public static final int INF = 10000;
	//Number of vertices in the graph
	private static int V;

	//flag if the graph has negative cycle
	private static boolean hasCycle = false;

	/**
	 * Computes Shortest path
	 * @param matrix: adjacency matrix
	 */
	public static void compute(int[][] matrix){
		V= matrix.length;
		int[][] sol= new int[matrix.length][matrix[0].length];

		//Copying 
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[i].length; j++)
				sol[i][j]=matrix[i][j];

		//Computing
		// fix k , and run for each src and dest
		for(int k=0;k<V;k++)
		{
			for(int i=0;i < V;i++)
			{
				for(int j=0;j < V;j++)
				{
					if(sol[i][k]!=INF &&  sol[k][j]!=INF)
						if(sol[i][k] + sol[k][j] < sol[i][j])
							sol[i][j] = sol[i][k] + sol[k][j] ;
				}
				if(sol[i][i]<0)
					hasCycle = true;
			}
		}

		if(!hasCycle)
		{
			System.out.println("===Input Adjacency Matrix============\n");
			print(matrix);
			System.out.println();
			System.out.println("===Shortest path Matrix==============\n");
			print(sol);
		}
		else
			System.out.println("The graph has Negative Cycle");
	}

	/**
	 * @param sol: Matrix containing Shortest paths
	 */
	private static void print(int[][] sol) {
		for(int i=0; i<sol.length; i++)
		{
			for(int j=0; j<sol[i].length; j++)
			{
				if(sol[i][j]!=INF)
					System.out.print(sol[i][j]+"\t");
				else
					System.out.print("INF"+"\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int matrix[][] =
			{ 
				{0,  	5,	 	1,		4},
				{INF,	0,		INF,	INF},
				{INF,	3,		0,		2},
				{INF,	INF,	INF,	0}
			};

		/*int matrix[][] =
			{ 
				{0,    5,  INF, INF , INF , INF},
				{INF,  0,  -5, INF , INF , INF},
				{INF,  INF,  0, INF , -6 , INF},
				{INF,  -1,  INF, 0 , INF , INF},
				{INF,  INF,  INF, -2 , 0 , 3},
				{INF,  INF,  INF, INF , INF , 0},
			};
		 */
		compute(matrix);
	}
}
