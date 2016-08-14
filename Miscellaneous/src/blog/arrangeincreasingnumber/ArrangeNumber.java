package blog.arrangeincreasingnumber;

/**
 * Increasing number of with given range of digits
 * @author r.prateek
 *
 */
public class ArrangeNumber {

	public static int count=0;
	public static void main(String[] args) {

		ArrangeNumber obj=new ArrangeNumber();

		System.out.println("The numbers are :");
		obj.arrangeNum(4,4); // inclusive
		System.out.println("Count of the numbers");
		System.out.println(count);
		
		//System.out.println(obj.countUtil(3, 9 -3 +1));
	}

	//print increasing numbers within range of digits
	private void arrangeNum(int startRange , int endRange){

		if(startRange == endRange +1 )
			return ;

		arrangeNumUtil(startRange , 0);

		arrangeNum(startRange + 1 , endRange) ;
	}


	private void arrangeNumUtil(int numDigits , int currentNum ){

		int digit = (currentNum % 10) + 1; //next digit from current Number
		currentNum *= 10; // move number to left
		for (; digit <= 9; digit++)
		{
			if (numDigits == 1){
				count++;
				System.out.println(currentNum + digit);
				return;
			}

			arrangeNumUtil(numDigits - 1, currentNum + digit);
		}
	}

	//-------------


/*	// Calculate the count of numbers with increasing digits
	private int count(int startRange , int endRange) {
		if(startRange == endRange +1 )
			return 0;

		return countUtil(startRange, 9 - startRange) + count(startRange + 1 , endRange) ;
	}

	*//**
	 * Counts the total number of combinations for a given number of digits
	 * initialisation digitRange=9;
	 *//*
	private int countUtil(int numDigits , int digitRange ){
		if(numDigits == 0)
			return 1;

		return digitRange * countUtil(numDigits - 1, digitRange -1 ) ;
	}
*/
}