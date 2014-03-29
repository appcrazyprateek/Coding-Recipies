package blog.nextpallindrome;

/**
 * Find Next Pallindrome Number
 * @author Prateek
 */
public class NextPallindrome {

	public static void main(String[] argc){
		int num= 8646;
          System.out.println(nextPanlindrome(num));
	}

	/**
	 * Get next pallindrome
	 */
	public static int nextPanlindrome(int num) {

		if(isPalindrome(num))
			num++;

		String temp = num + "";
		int end=temp.length() -1;
		int base=1;

		for(int start = 0; start < end; start++, end--)
		{

			// Gives the right digit
			int right = Integer.parseInt(temp.charAt(end)+"") * base;

			// Gives the left digit
			int left = Integer.parseInt(temp.charAt(start)+"") * base;

			// add differnce to the number
			num = num + left - right  ;		 //------(1)

			base *=10;

			if(right > left)
			{
				num += base;		// for incresing the value of number which got decreased at (1)

				// previous step indroduces asymmetry if its a even number.
				if(start == end - 1)  // For even numbers eg. case 8468 (adjacent digits)
					num += base/10;
			}
			temp = num + "";
		}

		return num;
	}

	/**
	 * Checks if a number is pallindriome
	 * @param num
	 * @return
	 */
	public static boolean  isPalindrome(int num)	{
		int reverse = 0, temp=num;

		while( temp != 0 )	{
			reverse = reverse * 10;
			reverse = reverse + temp%10;
			temp = temp/10;
		}
		return (num == reverse ? true: false);
	}
}
