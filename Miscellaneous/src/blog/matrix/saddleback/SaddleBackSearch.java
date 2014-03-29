package blog.matrix.saddleback;

/**
 *Saddle Back Search in a Matrix, with rows and columns Sorted
 * @author Prateek
 */
public class SaddleBackSearch {

	static int[][] matrix= {
		{ 11, 21, 31, 41, 51 },
		{ 12, 22, 32, 42, 52 },
		{ 13, 23, 33, 43, 53 } ,
		{ 14, 24, 34, 44, 54 },
		{ 15, 25, 35, 45, 55 }
	};

	public void find(int[][] martix , int num) {

		int rLen=matrix.length;
		int cLen=martix[0].length ;

		int row=cLen-1;
		int col=0;
	
		// Start from top Right
		while( row >= 0 && col < rLen)
		{
				//Move Down
				if(num > matrix[row][col]) 
					col++;

				//Move Left
				else if(num < matrix[row][col])
					row--;
				
				//Element Found
				else
				{
					System.out.println("Found at : ( "+ row+ " , "+ col + "  ) ");
					return ;
				}
		}
		System.out.println(num + " not found");
	}

	public static void main(String[] args) {
		SaddleBackSearch fnum=new SaddleBackSearch();
		fnum.find(matrix, 27);
	}
}
