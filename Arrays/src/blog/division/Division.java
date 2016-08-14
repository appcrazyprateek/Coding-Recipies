package blog.division;

/**
 * Division without using '/' operator
 * @author PRATEEK
 */
public class Division {

	public static int division(int dividend, int divisor) {
		if (divisor == 0)
			throw new ArithmeticException("Division by Zero");

		boolean isPositive = true; // flag for negative number

		if (dividend < 0) {
			isPositive = !isPositive; // toggle flag, i.e.negative
			dividend *= -1; // make divident positive
		}

		if (divisor < 0) {
			isPositive = !isPositive;
			divisor *= -1;
		}

		int temp, mul, result = 0;
		for (; dividend >= divisor; dividend -= temp >> 1, result += mul >> 1)
			for (mul = 1, temp = divisor; temp <= dividend; temp <<= 1, mul <<= 1);
	
		return result;
	}

	public static void main(String[] args) {
		int numerator = 56;
		int denominator = 5;
		int ans = division(numerator, denominator);
		System.out.println(numerator+"/"+denominator+"="+ans);
	}
}
