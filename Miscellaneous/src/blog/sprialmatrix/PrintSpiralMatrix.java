package blog.sprialmatrix;

/**
 * Print Matrix in spiral order
 * 
 * @author PRATEEK
 */
public class PrintSpiralMatrix {

	/**
	 * Spiral order printing
	 * @param matrix
	 */
	public static void printSpiral(int[][] matrix) {
		int rowSize = matrix.length;
		int colSize = matrix[0].length;

		int row = 0, col = 0, i;

		while (row < rowSize && col < colSize) {
			i = col;
			for (; i < colSize - col; i++)
				System.out.print(matrix[row][i] + "  ");

			i = row + 1;
			for (; i < rowSize - row; i++)
				System.out.print(matrix[i][colSize - col - 1] + "  ");

			i = (colSize - 1 - col) - 1;
			for (; i >= col; i--)
				System.out.print(matrix[rowSize - row - 1][i] + "  ");

			i = (rowSize - 1 - row) - 1;
			for (; i > row; i--)
				System.out.print(matrix[i][col] + "  ");

			row++;
			col++;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };
		printSpiral(matrix);
	}
}
