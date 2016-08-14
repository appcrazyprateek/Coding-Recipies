package blog.matrix.transpose;

/**
 * Transpose Matrix
 * @author Prateek
 */
public class TransposeMatrix {
	static int mat[][] = {
					{1,   2,   3,   4,  5},
					{6,   7,   8,   9,  10},
					{11,  12,  13,  14, 15},
					{16,  17,  18,  19, 20}
				};
	
	public static void main(String[] args) {
		printTransposeMatrix();
	}
	
	public static void printTransposeMatrix()
	{
		int row=mat.length;
		int col=mat[0].length;
		
		for(int j=0;j<col;j++)
		{
			for(int i=0;i<row;i++)
			{
				System.out.print(mat[i][j] + "\t\t");
			}
			System.out.println();
		}
	}
	
	
}
