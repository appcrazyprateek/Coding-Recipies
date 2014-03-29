package blog.magicsquare;

/**
 * 
 * @author Prateek
 *
 */
public class MagicSquare {

	int[][] matrix;
	int size;
	int k;
	
	public static void main(String[] args) {
		int[][] matrix = {  { 1, 2, 3, 4 } ,
							{ 5, 6, 7, 8 } ,
							{ 9, 10, 11, 12 } ,
							{ 13, 14, 15, 16 } ,
		};
		
		MagicSquare obj=new MagicSquare(matrix);
		obj.solve();
		
	}
	
	public MagicSquare(int[][] matrix) {
		this.matrix=matrix ;
		this.size = matrix.length ;
		this.k=size/4;
	}
	
	public void solve(){
		swapCol();
		swapRow();
		printMatrix();
	}
	
	private void printMatrix(){
		for(int i=0; i< matrix[0].length; i++ )
		{
			for(int j=0; j< matrix.length ; j++)
			{
				System.out.print(matrix [ i] [j] + "\t");
			}
			System.out.println();
		}
	}
	
	private void swapCol(){
		int j=size-1;
	    int i=0;
		
	    while(j > size - 1 - k)
			j--;
		
		while(i < k)
			i++;
		
		while(i< 3*k ) // && j > k)
		{
			swap(i, 0 , j , size -1 ) ;
			i++;
			j-- ;
		}
	}
	
	private void swapRow() {
			int j=size-1;
		    int i=0;
			
		    while(j > size - 1- k)
				j--;
			
			while(i < k)
				i++;
			
			while(i< 3*k ) // && j > k)
			{
				swap(0, i ,  size -1  , j) ;
				i++;
				j-- ;
			}
	}
	
	private void swap(int x1 , int y1 , int x2 , int y2) {
		int temp = matrix [x1 ][ y1] ;
		matrix [x1 ][ y1]= matrix[x2] [y2] ;
		matrix[x2] [y2] = temp;
	}
}
