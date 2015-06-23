package blog.concenriccircle;
import static java.lang.Math.abs;
import static java.lang.Math.min;
public class ConcentricSquare {

	public static void main(String[] args) {
		int num = 4;
		concentricSquare(num);
	}

	public static void concentricSquare(int num) {
		int size = 2*num-1;
		
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				
				int rowDepth = num - 1 - abs(row - num);
				int colDepth = num - 1 - abs(col - num);
				
				int minDepth = min(rowDepth, colDepth);
				
				System.out.print(num - minDepth + "  ");
			}
			System.out.println();
		}
	}
}
