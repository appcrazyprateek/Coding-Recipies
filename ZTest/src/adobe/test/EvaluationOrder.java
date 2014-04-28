package adobe.test;

import java.util.ArrayList;
import java.util.List;

public class EvaluationOrder {

	public static void main(String[] args) {
		
		int[][] numbers = { 
				{1, 2, 3, 4}, 
				{5, 6, 7, 8},
				{9, 10, 11, 12}, 
				{13, 14, 15, 16},
				
		};

		int size=4;
		
		
		for (int i = size - 1, j = 0; i >= 0; i--, j++) {

			for (int k = j; k < i; k++)
				System.out.print(numbers[j][k] + " ");
			for (int k = j; k < i; k++)
				System.out.print(numbers[k][i] + " ");
			for (int k = i; k > j; k--)
				System.out.print(numbers[i][k] + " ");
			for (int k = i; k > j; k--)
				System.out.print(numbers[k][j] + " ");

		}
	}

}