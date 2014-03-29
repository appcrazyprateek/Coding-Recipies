package blog.validblock;
import java.util.Scanner;
import java.io.FileInputStream;
/*
   As the name of the class should be Solution, using Solution.java as the filename is recommended.
In any case, you can execute your program by running 'java Solution' command.
 */
public class ValidBlock
{
	final static int T = 10;
	static int Board[][] = new int[501][501];
	static int Answer1, Answer2, Answer3, Answer4;
	static int N;

	public static void main(String args[]) throws Exception
	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */
		// System.setIn(new FileInputStream("input.txt"));

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(System.in);
		/*
		   Your program should handle 10 test cases given.
		 */
		for(int test_case = 1; test_case <= T; ++test_case)
		{
			/*
			   Read each test case from standard input.
			   Read N, and the matrix Board[1..N][1..N].
			 */
			N = sc.nextInt();
			for(int i = 1; i <= N; ++i)
			{
				for(int j = 1; j <= N; ++j)
				{
					Board[i][j] = sc.nextInt();
				}
			}


			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answers to the case will be stored in variable Answer1, Answer2, Answer3, Answer4.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			// Answer1 = Answer2 = Answer3 = Answer4 = 0;

			// Print the answer to standard output(screen).
			System.out.println("#" + test_case + " " + Answer1 + " " + Answer2 + " " + Answer3 + " " + Answer4);
		}
	}
	
	
	int[][] matrix;
	int size = matrix.length;
	public int isValid(int row, int col , int[][] matrix){

		int isblock1= isBlock1(row, col , matrix);
		int isblock2= isBlock1(row, col , matrix);
		int isblock3= isBlock1(row, col , matrix);
		int isblock4= isBlock1(row, col , matrix);

		return (isblock1 + isblock2 + isblock3  + isblock4 );
	}

	public int isBlock1(int row, int col , int[][] matrix){
		if(row - 1 > 0  &&   col + 1 < size){
			if( (matrix[row -1][col] == 1) && (matrix[row ][col + 1] == 1) ){
				return 1 ;
			}
		}
		return 0;
	}

	public int isBlock2(int row, int col , int[][] matrix){
		if(row + 1 < size && col + 1 < size){
			if( (matrix[row + 1][col] == 1) && (matrix[row ][col + 1] == 1) ){
				return 2 ;
			}
		}
		return 0;
	}

	public int isBlock3(int row, int col , int[][] matrix){
		if(row + 1 > size && col - 1 > 0){
			if( (matrix[row ][col - 1] == 1) && (matrix[row + 1][col ] == 1) ){
				return 3 ;
			}
		}
		return 0;
	}

	public int isBlock4(int row, int col , int[][] matrix){
		if(row - 1 > 0 && col - 1 > 0){
			if( (matrix[row -1][col] == 1) && (matrix[row ][col - 1] == 1) ){
				return 4 ;
			}
		}
		return 0;
	}
}
