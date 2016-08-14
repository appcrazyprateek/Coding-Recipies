package blog.matrix.misc;

/**
 * Given Matrix with sorted rows of 0s and 1s , find max zeros in any row
 * @author PRATEEK
 *
 */
public class MaxZeros {

	public static void main(String[] args) {
		int[][] matrix = { 
				{0, 0, 1, 1, 1, 1 },
				{0, 0, 0, 0, 1, 1 },
				{0, 0, 0, 1, 1, 1 },
				{0, 0, 0, 0, 0, 1 },
				{0, 0, 1, 1, 1, 1 },
				{0, 0, 0, 1, 1, 1 },
				{0, 0, 0, 1, 1, 1 }
		};
		
		maxZeros(matrix);
	}
	
	public static int maxZeros(int[][] matrix){
		
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
		int max = -1;
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=max+1;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==0)
					max++;
				else
					break;
			}
		}
		System.out.println(max);
		return max+1;
	}
}
