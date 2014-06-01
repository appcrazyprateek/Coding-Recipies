package blog.backtrack.soduku;
/**
 * Solve Soduku using backtracking
 * @author Prateek
 */
public class SolveSoduku {

	private static final int BLANK = 0;

	//Soduku to be solved
	private static int[][] soduku; 

	//Size of Soduku
	private final int size;
	//Size of the Block in which checking to be done, it is sqrt of size of soduku
	private int boxSize;

	/**
	 * Constructor
	 * @param soduku
	 * @throws Exception
	 */
	public SolveSoduku(int[][] soduku) throws Exception{
		this.soduku = soduku;

		if(soduku.length == soduku[0].length) {//Square marix required
			this.size=soduku.length;
			this.boxSize = (int) Math.sqrt(this.size);
		}
		else
			throw new Exception("Invalid Matrix");
	}

	/**
	 * Subroutine to solve the Soduku
	 * @return true if soduku is solvable
	 */
	public boolean  solve(int row, int col){
	
		if(soduku[row][col]!= BLANK)
			nextCell(row,col);

		else
		{
			//Try the vacant cell with every Number
			for(int num=1; num<=size ; num++ )
			{

				//check if current number can fit the cell with the given constraints
				if(isValid(row, col, num)) 
				{
					
				//	System.out.println(row +" : "+col+" : "+num);
					
					//if(row==8 && col==8)
						//System.out.println("Test");
					
					soduku[row][ col] = num;  //Assuming to be true

					if(row==size-1 && col==size-1)
					{
						printSoduku();
						return true;
					}
					
					if(solve(row, col)) //will be called again and other cells will be processed
						return true;
					
					//System.out.println("Num: "+num + " row:"+row +" col:"+col);
					//printSoduku();
					soduku[row][ col] = BLANK; //Reverting
				}
			}
		}
		return false;  //will be reached if for any cell none of the number(1-9) fit
	}

	/**
	 * Find the next free cell
	 * @return , true if free cell found and currentRow and currentColumn are set
	 */
	private void nextCell(int row , int col) {
		if( col < size -1  )
			solve( row, col + 1) ;
		else if(row < size -1 )
			solve( row + 1, 0) ;
	}


	/**
	 * check validy of number at the given position, combining the result of 3 conditions
	 * @return true, if the number can fit at the current position
	 */
	private boolean isValid( int row , int col, int num){
		return checkRow(row,col,num) && checkCol(row,col,num) && checkBox(row - row % boxSize,col - col % boxSize,num);
	}


	/**
	 * Check particular for the existance of given number (in a particular row)
	 * @return true if the number does not exist
	 */
	private boolean checkRow(int row, int col , int num){
		for(int c=0 ; c < size ; c++) 	
			if(soduku[row][c]==num)  
				return false;
		return true;
	}

	/**
	 *  Check particular for the existance of given number (in a particular col)
	 * @return true if the number does not exist
	 */
	private boolean checkCol(int row , int col,int num){
		for(int r=0 ; r < size ; r++) 	
			if(soduku[r][col]==num)  
				return false;
		return true;
	}

	/**
	 * Check particular for the existance of given given BOX
	 * @return true if the number does not exist
	 */
	private boolean checkBox(int row , int col , int num){
	//	row= row - row % boxSize ;
	//	col = col - col % boxSize ;

		for(int r=0 ; r <  boxSize  ; r ++)
		{
			for(int c=0 ; c < boxSize  ; c ++)
			{
				if(soduku[r + row][c + col] == num)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		int[][] soduku = {
				{3, 0, 6,  5, 0, 8,  4, 0, 0},
				{5, 2, 0,  0, 0, 0,  0, 0, 0},
				{0, 8, 7,  0, 0, 0,  0, 3, 1},

				{0, 0, 3,  0, 1, 0,  0, 8, 0},
				{9, 0, 0,  8, 6, 3,  0, 0, 5},
				{0, 5, 0,  0, 9, 0,  6, 0, 0},

				{1, 3, 0,  0, 0, 0,  2, 5, 0},
				{0, 0, 0,  0, 0, 0,  0, 7, 4},
				{0, 0, 5,  2, 0, 6,  3, 0, 0}
		};

		SolveSoduku obj = new SolveSoduku(soduku);
		obj.solve(0, 0);
	//	obj.printSoduku();
	}

	private void printSoduku()
	{
		for (int row = 0; row < size; ++row)
		{
			if (row % boxSize == 0)
				System.out.println("+-------+-------+-------+");

			for (int col = 0; col < size; col++)
			{
				if (col % boxSize == 0) System.out.print("| ");

				System.out.print(soduku[row][col] == 0 ? "  " : soduku[row][col] + " " );
			}
			System.out.println("|");
		}
		System.out.println("+-------+-------+-------+");
	}
}
