package blog.matrix.pascaltriangle;

/**
 * Pascal Triangle
 * @author Prateek Rathore
 */
public class PascalTriangle {
	public static void main(String[] args) {
		create(6);
	}
	
	/**
	 * Create the Pascal Triangle
	 */
	public static void create(int row){
		int[][] matrix = new int[row][row];
		for(int i=0;i<row;i++){
			matrix[0][i]=1;
			matrix[i][0]=1;
		}

		for(int i=1;i<row;i++)	{
			for(int j=1;j<row-i;j++)
				matrix[i][j] = matrix[i-1][j] +  matrix[i][j-1] ;
		}
		print(row, matrix);
	}

	/**
	 * Print The pascal Trianlge
	 */
	public static void print(int row, int[][] matrix){
		for(int i=0;i<row;i++){
			printRow(i, matrix);
			System.out.println();
		}
	}

	/**
	 * Print Each row
	 */
	public static void printRow(int row , int[][] matrix){
		int len=row;
		row--;
		for(int i=0 ; i< len ; i++){
			System.out.print(matrix[row][i]+"\t");
			row--;
		}
	}
}
