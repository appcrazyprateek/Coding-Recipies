package com.amazon.ecp;

public class MinSquare {

	public static void main(String[] args) {
//		System.out.println(count(11, 13));
		for(int i = Math.min(rowLen, colLen); i>0; i--){
			System.out.println(count(rowLen, colLen, i, 0));
		}
	}

	
	
	static int rowLen = 10;
	static int colLen = 10;
	
	static int  count(int rowleng, int colleng, int iniSize, int sum){
		if(rowleng == 0 || colleng == 0){
			return 0;
		}
		int min;
		if(iniSize != 0){
			min = iniSize;
		}else{
			min = Math.min(rowleng, colleng);
		}
		return Math.min(count(rowleng-min, colleng, 0, sum ) +
			count(rowleng, colleng - min, 0, sum),
		
			count(rowleng, colleng - min, 0, sum) + count(rowleng-min, colleng, 0, sum )) + 1;
	}
}
