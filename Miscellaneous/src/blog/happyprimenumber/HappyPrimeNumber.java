package blog.happyprimenumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Print happy prime numbers
 * @author PRATEEK
 */
public class HappyPrimeNumber {

	private final int INIFINITY = 400160;

	/**
	 * Prints n happy prime numbers
	 * 
	 * @param n
	 *            : number of primes to be printed
	 */
	public static int happyPrimes(int n) {
		int c = 0, i = 7, s = 0;
		for (;c < n; i += 2) {
			 if (p(i) && h1(i, new HashSet<Integer>())) {
			//if (p(i) && h2(i)) {
				s += i;
				c++;
				System.out.println(i);
			}
		}
		return s;
	}

	/**
	 * To check if the number is Happy Happy Number (WIKIPEDIA): A happy number
	 * is a number defined by the following process: Starting with any positive
	 * integer, replace the number by the sum of the squares of its digits, and
	 * repeat the process until the number equals 1 (where it will stay), or it
	 * loops endlessly in a cycle which does not include 1. Those numbers for
	 * which this process ends in 1 are happy numbers, while those that do not
	 * end in 1 are unhappy numbers (or sad numbers)
	 * 
	 * @return: true if number is happy
	 */
	private static boolean h1(int num, Set<Integer> set) {
		if (!set.add(num))
			return false;
		if (num == 1)
			return true;

		int digit = 0, sum = 0;
		while (num > 0) {
			digit = num % 10;
			num /= 10;
			sum += digit * digit;
		}
		return h1(sum, set);
	}

	public static boolean h2(int n) {
		int s = 0, d;
		Set<Integer> h = new HashSet<Integer>();

		while (n != 1 && h.add(n)) {
			s = 0;
			while (n > 0) {
				d = n % 10;
				s += d * d;
				n /= 10;
			}
			n = s;
		}
		return s == 1;
	}

	private static boolean p(int num) {
		for (int p = 3; p <= num / 2; p += 2)
			if (num % p == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		happyPrimes(5);
	}

}
