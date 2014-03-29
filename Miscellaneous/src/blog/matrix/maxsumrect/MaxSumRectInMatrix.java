package blog.matrix.maxsumrect;

import java.util.Arrays;

public class MaxSumRectInMatrix {

	static int ROW=0;
	static int COL=0;
	static int startRow;
	static int startCol;
	static int endRow;
	static int endCol;
	static int  finalLeft, finalRight, finalTop, finalBottom;
	
	public static void main(String[] args) {

		int M[][] = {
						{1,   2,   -1,   -4,  -20},
						{-8, -3,    4,    2,    1},
						{3,   8,   10,    1,    3},
						{-4, -1,    1,    7,   -6}
					};
		
		ROW=M.length;
		COL=M[0].length;
		
		MaxSumRectInMatrix obj=new MaxSumRectInMatrix();
		obj.findMaxSum(M);

	}

	void findMaxSum(int M[][])
	{
		// Variables to store the final output
		int maxSum = 0;

		int left, right, i;
		int sum;
		int temp[] = new int[ROW];
		// Set the left column
		for (left = 0; left < COL; ++left)
		{
			Arrays.fill(temp, 0);
			// Set the right column for the left column set by outer loop
			for (right = left; right < COL; ++right)
			{
				
				// Calculate sum between current left and right for every row 'i'
				for (i = 0; i < ROW; ++i)
					temp[i] += M[i][right];

				// Find the maximum sum subarray in temp[]. The kadane() function
				// also sets values of start and finish.  So 'sum' is sum of
				// rectangle between (start, left) and (finish, right) which is the
				//  maximum sum with boundary columns strictly as left and right.
				sum = kadane(temp);

				// Compare sum with maximum sum so far. If sum is more, then update
				// maxSum and other output values
				if (sum > maxSum)
				{
					maxSum = sum;
					finalLeft = left;  // start col
					finalRight = right;  // end col
					finalTop = startRow;  // start row
					finalBottom = endRow; //end row
				}
			}
		}

		// Print final values
		System.out.println("(startRow,startCol): " + "<"+finalTop +","+finalLeft+">");
		System.out.println("(startRow,startCol):"+ "<"+finalBottom +","+finalRight+">");
		System.out.println("Max sum is: %d\n"+maxSum);
	}

	public int kadane(int arr[])
	{
		int currentSum=0;
		int maxSum = 0;
		for(int i=0;i<arr.length;i++)
		{
			currentSum+=arr[i];
			if(currentSum<0)
			{
				currentSum=0;
				startRow=i+1;
			}
			else if(maxSum<currentSum)
			{
				maxSum=currentSum;
				endRow=i;
			}
		}
		return maxSum;
	}
}
