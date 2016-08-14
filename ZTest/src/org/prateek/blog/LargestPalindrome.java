package org.prateek.blog;


public class LargestPalindrome {

	private int[][] matrix;
	private int global;
	public LargestPalindrome(int size){
		matrix =  new int[size][size];
	}
	public int largestPalindrome(int m,int n){
		if(m <= 0 || n <= 0){
			return 0;
		}
		if(matrix[m-1][n-1] != 0){
			return matrix[m-1][n-1];
		}
		int product = m*n;
		if(isPal(product)){
			matrix[m-1][n-1] = product;
			matrix[n-1][m-1] = product;
			return product;
		}else{
			matrix[m-1][n-1] = -1;
			matrix[n-1][m-1] = -1;
		}
		int product1 = largestPalindrome(m, n-1);
		int product2 = largestPalindrome(m-1, n);
		
		if(product1 <= product2){
			return product2;
		}else{
			return product1;
		}
	}
	private Boolean isPalindrome(int num){
		if(oneDigit(num)){
			return (num == (global%10));
		}
		if(!(isPalindrome(num/10))){
			return false;
		}
		global /= 10;
		return (num % 10 == global%10);
	}
	private Boolean oneDigit(int num){
		if(num <=10 && num >= 0){
			return true;
		}
		return false;
	}
	public Boolean isPal(int num){
		if(num < 0){
			num = -num;
		}
		this.global = num;
		return isPalindrome(num);
	}
	public static void main(String args[]){
		long start = System.nanoTime() ;
		//System.out.println("StartTime-->"+start);
		//int inputNumber  = 12321;
		LargestPalindrome largestPalindrome = new LargestPalindrome(100);
		System.out.println(largestPalindrome.largestPalindrome(100, 100));
		long end = System.nanoTime();
		//System.out.println("EtartTime-->"+end);
		System.out.println((end - start)+" ns\n");
	}
}
