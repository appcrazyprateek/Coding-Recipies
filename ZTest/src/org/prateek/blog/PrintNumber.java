package org.prateek.blog;

/**
 * Extracts the digits of a number using recursion
 * @author Prateek
 */
public class PrintNumber {

	/**
	 * Print the numeber as it is
	 */
	public static void print(int num){
		if(num/10 ==0 && num%10==0)
			return ;
		print(num/10);
		System.out.print(num%10 + "\t");
	}

	/**
	 * Prints the number in reverse order
	 */
	public static void printReverse(int num){
		if(num/10 ==0 && num%10==0)
			return ;
		System.out.print(num%10 + "\t");
		printReverse(num/10);
	}
	
	public static void main(String[] args) {
		int num = 759320;
		print(num);
		System.out.println();
		printReverse(num);
	}
}
