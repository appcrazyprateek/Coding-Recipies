package blog.median.sortedarrays;

public class FindMedian1 {
	static int[][] mat = {
							{1,2,3,7,9},
							{10,11,14,15,17}
				        };

	public static void main(String[] args) {
		findMedian(mat);
	}
	
	private static int findMedian(int[][] mat) {
		int numRows = mat.length;
		int numCols = mat[0].length;
		int[] pointerIndexes = new int[numRows];

		int medianIndex = numRows * numCols / 2;

		int count = 0;
		int minIndex = 0;
		while (count < medianIndex -1 ) {
			minIndex = getMinIndex(mat, pointerIndexes);
			pointerIndexes[minIndex]++;
			count++;
		}

		int result = mat[minIndex][pointerIndexes[minIndex]];
		System.out.println(result);
		return result;
	}

	private static int getMinIndex(int[][] mat, int[] pointers) {
		int numRows = mat.length;
		int numCols = mat[0].length;
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		int len = pointers.length;

		for (int i = 0; i < numRows; i++) {
			if (pointers[i] < numCols && mat[i][pointers[i]] < min) {
				min = mat[i][pointers[i]];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
